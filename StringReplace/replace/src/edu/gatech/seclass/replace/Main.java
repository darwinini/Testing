package edu.gatech.seclass.replace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO: Empty skeleton method

        System.out.println("Welcome to the Replace Utility");
        System.out.println("Enter your input in the following format: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>] ");

        System.out.println("Welcome to the Replace Utility");
        System.out.println("Enter your input in the following format: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>] ");


        Scanner inputCommand = new Scanner(System.in);

        String inputs = inputCommand.nextLine();
        String commands = inputs.replace("Replace ", "");
        String[] commandsArray = commands.split(" ");

        CommandOptions cmdOptions = new CommandOptions();
        cmdOptions.parseCommandOptions(commandsArray);

    }

    private static void usage() {
        System.err.println("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- " + "<filename> [<filename>]*");
    }

}