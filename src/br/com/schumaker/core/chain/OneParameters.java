package br.com.schumaker.core.chain;

import br.com.schumaker.core.Properties;
import br.com.schumaker.core.Runner;

/**
 *
 * @author Hudson Schumaker
 */
public class OneParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 1) {
            Properties p = Properties.getInstance();
            if (p.validatePath(params[0])) {
                p.setOriginPath(params[0] + "/");
                p.setDestinationPath(params[0] + "/");
            } else {
                System.out.println("Caminho nao valido, usando diretorio corrente para origem e destino");
                p.setOriginPath(System.getProperties().getProperty("user.dir") + "/");
                p.setDestinationPath(System.getProperties().getProperty("user.dir") + "/");
            }
            Runner runner = new Runner();
            runner.start();
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
