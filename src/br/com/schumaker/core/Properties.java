package br.com.schumaker.core;

import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
public class Properties {

    private String originPath;
    private String destinationPath;
    private String pelican;
    private String flux;

    private static final Properties INSTANCE = new Properties();

    private Properties() {
    }

    public static Properties getInstance() {
        return INSTANCE;
    }

    public String getOriginPath() {
        return originPath;
    }

    public void setOriginPath(String p) {
        originPath = p;
    }

    public boolean validatePath(String p) {
        File file = new File(p);
        return file.exists();
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public String getPelican() {
        return pelican;
    }

    public void setPelican(String pelican) {
        this.pelican = pelican;
    }

    public String getFlux() {
        return flux;
    }

    public void setFlux(String flux) {
        this.flux = flux;
    }
}
