package it.intersistemi.corsojava.letturafile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

public class CopiaFile {

    public static void main(String[] args) {
        //JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        File cwd = new File(System.getProperty("user.dir"));
        JFileChooser jfc = new JFileChooser(cwd);

        File inputFile = null;
        File outputFile = null;

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            inputFile = jfc.getSelectedFile();

            returnValue = jfc.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                outputFile = jfc.getSelectedFile();
            }

        }

        System.out.println("inputFile: " + inputFile);
        System.out.println("outputFile: " + outputFile);
        if (inputFile != null && outputFile != null) {
            try (
                    FileInputStream fis = new FileInputStream(inputFile);
                    FileOutputStream fos = new FileOutputStream(outputFile)
            ) {

                long startMillis = System.currentTimeMillis();
                int byteCopiati = 0;

/**        int read;
 while((read = fis.read()) != -1) {
 byteCopiati++;
 fos.write(read);
 }
 */byte[] buffer = new byte[1024];
                int read;
                while ((read = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, read);
                    byteCopiati += read;

                }
                long endMillis = System.currentTimeMillis();
                System.out.println(byteCopiati + " copiati in " + (endMillis - startMillis) + " millisecondi");

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
