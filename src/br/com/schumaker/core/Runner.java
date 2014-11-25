package br.com.schumaker.core;

import br.com.schumaker.io.HsFilesLib;

/**
 *
 * @author Hudson Schumaker
 */
public class Runner implements Runnable {

    private Thread thread;

    public Runner() {
    }

    public void start() {
        thread = new Thread(this);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
    }

    private void doJob() {
        HsFilesLib hsFilesLib = HsFilesLib.getInstance();
        hsFilesLib.remaneFilesCreatePst(hsFilesLib.getListFiles());
    }

    @Override
    public void run() {
        doJob();
    }
}
