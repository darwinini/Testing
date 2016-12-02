package edu.gatech.seclass.replace;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;



/**
 * Created by Darwin on 11/13/16.
 */
public class Backup extends CommandObj
{
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    LinkedList<String> backupFiles = new LinkedList<String>();
    public void Process(LinkedList<String> fileNames) {
        for (int i = 0; i < fileNames.size(); ++i) {
            String fileContents = getFileContent(fileNames.get(i));

            try {

                //check if backup file doesn't exists do...
                //if(){}
                File file1 = new File(fileNames.get(i) + ".bck");

                FileWriter fileWriter = new FileWriter(file1);

                fileWriter.write(fileContents);

                fileWriter.close();
                //return file1;
            } catch (IOException io) {
                //output message for error
                System.out.println("File did not backup");
            }
        }
    }

    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


}
