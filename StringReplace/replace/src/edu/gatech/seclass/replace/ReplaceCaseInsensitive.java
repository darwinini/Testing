package edu.gatech.seclass.replace;

import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by Darwin on 11/13/16.
 */
public class ReplaceCaseInsensitive extends CommandObj {

    private String originalWord = "";
    private String replacementWord = "";

    public ReplaceCaseInsensitive() {}
    public ReplaceCaseInsensitive(String[] args, int index)
    {

    }

    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    public void Process(LinkedList<String> fileNames) {
        for(int i = 0; i < fileNames.size(); ++i)
        {
            String fileContent = getFileContent(fileNames.get(i));

            String temp =  fileContent.replaceAll(originalWord, replacementWord);

            // Save file

        }
    }

    private File createTmpFile() throws IOException {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
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
