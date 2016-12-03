package edu.gatech.seclass.replace;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO: Empty skeleton method

        System.out.println("Welcome to the Replace Utility");
        System.out.println("Enter your input in the following format: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>] ");

        System.out.println("Welcome to the Replace Utility");
        System.out.println("Enter your input in the following format: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>] ");

        String[] commandsArray;

        if (args.length != 0) {
            commandsArray = args;
        } else {
            Scanner inputCommand = new Scanner(System.in);
            String inputs = inputCommand.nextLine();
            String commands = inputs.replace("Replace ", "");

            commandsArray = commands.split(" ");
        }

        CommandOptions cmdOptions = new CommandOptions();
        cmdOptions.parseCommandOptions(commandsArray);
        cmdOptions.processCommand();

        usage();
    }

    private static void usage() {
        System.err.println("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- " + "<filename> [<filename>]*");
    }

}