package br.com.schumaker.run;

import br.com.schumaker.core.chain.Chain;
import br.com.schumaker.core.chain.HelpParameters;
import br.com.schumaker.core.chain.OneParameters;
import br.com.schumaker.core.chain.TwoParameters;
import br.com.schumaker.core.chain.ZeroParameters;

/**
 *
 * @author Hudson Schumaker
 */
public class Run {

    public static void main(String[] args) {
        Chain zeroParam = new ZeroParameters();
        Chain helpParam = new HelpParameters();
        Chain oneParam = new OneParameters();
        Chain twoParam = new TwoParameters();

        zeroParam.setNextChain(helpParam);
        helpParam.setNextChain(oneParam);
        oneParam.setNextChain(twoParam);

        zeroParam.executeProgram(args);
    }
}
