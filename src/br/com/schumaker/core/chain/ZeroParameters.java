package br.com.schumaker.core.chain;

import br.com.schumaker.core.Properties;
import br.com.schumaker.core.Runner;

/**
 *
 * @author Hudson Schumaker
 */
public class ZeroParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 0) {
            Properties p = Properties.getInstance();
            System.out.println("Caminho não especificado, usando diretorio corrente para origem e destino");
            p.setOriginPath(System.getProperties().getProperty("user.dir") + "/");
            p.setDestinationPath(System.getProperties().getProperty("user.dir") + "/");
            Runner runner = new Runner();
            runner.start();
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
