package br.com.schumaker.core.chain;

/**
 *
 * @author Hudson Schumaker
 */
public interface Chain {
    void setNextChain(Chain c);
    void executeProgram(String[] params);
}
