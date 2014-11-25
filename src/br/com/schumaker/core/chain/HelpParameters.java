package br.com.schumaker.core.chain;

/**
 *
 * @author Hudson Schumaker
 */
public class HelpParameters implements Chain {

    private Chain nextInChain;

    @Override
    public void setNextChain(Chain c) {
        this.nextInChain = c;
    }

    @Override
    public void executeProgram(String[] params) {
        if (params.length == 1 && (params[0].equalsIgnoreCase("-h") || params[0].equalsIgnoreCase("-help"))) {
            System.out.println("*** O programa aceita 0, 1 e 2 parametros ***");
            System.out.println("-0 parametros: o diretorio local sera o local trabalho");
            System.out.println("-1 parametro: path sera usado para origem e destino");
            System.out.println("-2 parametros: primeiro parametro como origem segundo parametro como destino");
        } else {
            nextInChain.executeProgram(params);
        }
    }
}
