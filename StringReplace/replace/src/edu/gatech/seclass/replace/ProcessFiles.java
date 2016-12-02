package edu.gatech.seclass.replace;

import java.util.LinkedList;

/**
 * Created by Darwin on 11/14/16.
 */
public class ProcessFiles extends CommandObj
{
    private LinkedList<String> fileNames = new LinkedList<String>();

    public ProcessFiles() {}


    public ProcessFiles(String[] args, int index)
    {
        int i = index + 1; // start after finding "--"
        while(i < args.length && (!args[i].contains("-") || !args[i].contains("--")))
        {
            if(args[i] != " ")
            {
                fileNames.add(args[i]);
            }

            ++i;
        }
    }

    public void Process(LinkedList<String> fileNames)
    {
        // Do Nothing
    }

    public LinkedList<String> GetFileNames()
    {
        return fileNames;
    }
}
