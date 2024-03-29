package br.com.schumaker.io;

import br.com.schumaker.core.Properties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hudson Schumaker
 */
public class HsFilesLib {

    private static final HsFilesLib INSTANCE = new HsFilesLib();

    private HsFilesLib() {
    }

    public static HsFilesLib getInstance() {
        return INSTANCE;
    }

    public ArrayList<String> getListFiles() {
        System.out.println("Start get list of Files");
        ArrayList<String> fileList = new ArrayList<String>();
        File folder = new File(Properties.getInstance().getOriginPath());
        File files[] = folder.listFiles(new HsFileFilter());
        for (File file : files) {
            if (file.isFile()) {
                if (!file.isHidden()) {
                    fileList.add(file.getName());
                }
            }
        }
        return fileList;
    }

    public String getFileExtension(String filename) {
        String ext[] = filename.split("\\.");
        int i = ext.length;
        String result = "";
        if (i > 1) {
            result = ext[i - 1];
        }
        return result;
    }

    public void savePstFile(String fileName) {
        String optimazedName[] = fileName.split("\\.");
        File file = new File(Properties.getInstance().getDestinationPath() + optimazedName[0] + ".pst");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write("PDDSU000\r\nF217\r\n" + fileName);//Acresentado a pedido do bira 25/11/14
            buffer.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void remaneFilesCreatePst(ArrayList<String> files) {
        Properties properties = Properties.getInstance();
        System.out.println("Start rename");
        for (String name : files) {
            File oldFile = new File(properties.getOriginPath() + name);
            String splitName[] = name.split("_");
            File newFile = new File(properties.getDestinationPath() + splitName[splitName.length - 1]);
            oldFile.renameTo(newFile);
            oldFile.delete();
            savePstFile(splitName[splitName.length - 1]);
        }
        System.out.println("End rename");
    }
}
