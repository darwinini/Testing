package edu.gatech.seclass.replace;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by Darwin on 11/13/16.
 */ //two collections
//1. list of filename
//2. Name value pair collection
//key: file name
//value: file contents
public abstract class InputFile extends CommandObj
{
    public void Init(String[] array, int pos)
    {
        for(int i = (pos+1); i < array.length; ++i)
        {
            if(array[i].endsWith(".txt"))
            {
                fileContents.add(array[i].indexOf(pos), getFileContent(array[i]));

            }
        }
    }

    private String getFileContent(String filename) {
        String content = null;
        try {
            //changed to default charset
            content = new String(Files.readAllBytes(Paths.get(filename)), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public LinkedList<String> fileNames = new LinkedList<String>();
    public LinkedList<String> fileContents = new LinkedList<String>();

    ProcessFiles temp = new ProcessFiles();

}
