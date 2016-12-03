package edu.gatech.seclass.replace;


import java.util.LinkedList;


public class CommandOptions {

    public LinkedList<String> fileNames = null;


    public LinkedList<CommandObj> commandList = new LinkedList<CommandObj>();


    public CommandOptions() {

    }

    public void parseCommandOptions(String[] args) {

        for (int i = 0; args.length > i; ++i) {
            String test = args[i];
            switch (test) {

                case "-b":
                    commandList.add(CommandFactory(CommandTypes.Type.Backup, args, i));
                    break;
                case "-f":
                    commandList.add(CommandFactory(CommandTypes.Type.ReplaceFirst, args, i));
                    break;
                case "-l":
                    commandList.add(CommandFactory(CommandTypes.Type.ReplaceLast, args, i));
                    break;
                case "-i":
                    commandList.add(CommandFactory(CommandTypes.Type.ReplaceCaseInsensitive, args, i));
                    break;
                case "--":
                    fileNames = ((ProcessFiles) CommandFactory(CommandTypes.Type.ProcessFiles, args, i)).GetFileNames();
                    break;
                default:
                    //handle erroneous input
                    break;


            }//switch
        }//for loop

    }//method

    public void processCommand() {

        for (CommandObj cmdObj : commandList) {
            cmdObj.Process(fileNames);
        }
    }

    private CommandObj CommandFactory(CommandTypes.Type type, String[] args, int index) {

        if (type == CommandTypes.Type.Backup) {
            return new Backup();
        } else if (type == CommandTypes.Type.ReplaceFirst) {
            return new ReplaceFirst(args, index);
        } else if (type == CommandTypes.Type.ReplaceLast) {
            return new ReplaceLast();
        } else if (type == CommandTypes.Type.ReplaceCaseInsensitive) {
            return new ReplaceCaseInsensitive();
        } else {
            return new ProcessFiles();
        }


    }


}//end of class


