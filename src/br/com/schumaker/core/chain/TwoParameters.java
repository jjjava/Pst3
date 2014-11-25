package br.com.schumaker.core.chain;

import br.com.schumaker.core.Properties;
import br.com.schumaker.core.Runner;

/**
 *
 * @author Hudson Schumaker
 */
public class TwoParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 2) {
            Properties p = Properties.getInstance();
            if (p.validatePath(params[0])) {
                p.setOriginPath(params[0] + "/");
            } else {
                System.out.println("Caminho nao valido para origem, usando diretorio corrente para origem");
                p.setOriginPath(System.getProperties().getProperty("user.dir") + "/");
            }
            if (p.validatePath(params[1])) {
                p.setDestinationPath(params[1] + "/");
            } else {
                System.out.println("Caminho nao valido para destino, usando diretorio corrente para destino");
                p.setDestinationPath(System.getProperties().getProperty("user.dir") + "/");
            }
            Runner runner = new Runner();
            runner.start();
        } else {
            System.out.println("O Programa funciona com 0, 1 e 2 parametros para path(es).");
        }
    }
}
