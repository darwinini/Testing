package edu.gatech.seclass.replace;

import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Darwin on 11/12/16.
 */
public class ReplaceFirst extends CommandObj
{
    private String originalWord = "";
    private String replacementWord = "";
    private Map<String, String> wordReplacement = new TreeMap<String, String>();
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    public LinkedList<String> commands = new LinkedList<String>();






    public ReplaceFirst() {}
    public ReplaceFirst(String[] args, int index)
    {
        //need try catch?
        try {
            Init(args, index);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void Init(String[] args, final int index) throws Exception {
        //throw exception and put error message in here
        //figure out exception handling

        commands.add("-b");
        commands.add("-f");
        commands.add("-l");
        commands.add("-i");
        commands.add("--");


        int replaceCount = 0;
        int counter = index+1;



        //how many words come after the loop
        while(counter < args.length)
        {
            //can commands.equals be used instead of commands.contains
            if(!commands.contains(args[counter]))
            {
                ++replaceCount;
            }

            else {
                throw new Exception();
            }

            counter++;
        }

        //check that the exception would work
        if(replaceCount %2 != 0) throw new Exception();

        for(int i = (index+1);  i < (index + replaceCount); ++i)
        {

                wordReplacement.put(args[i], args[i+1]);

        }
    }

    public void Process(LinkedList<String> fileNames) {
        for(int i = 0; i < fileNames.size(); ++i)
        {
            String fileContent = getFileContent(fileNames.get(i));

            //String temp =  fileContent.replaceFirst(originalWord, replacementWord);
            for(Map.Entry<String, String> entry : wordReplacement.entrySet())
            {
                fileContent = fileContent.replaceFirst(entry.getKey(), entry.getValue());
            }
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
