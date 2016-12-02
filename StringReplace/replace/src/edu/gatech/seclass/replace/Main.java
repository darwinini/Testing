package edu.gatech.seclass.replace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // TODO: Empty skeleton method


        System.out.println("Welcome to the Replace Utility");
        System.out.println("Enter your input in the following format: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>] ");

        String Input = null;
        System.out.println("Welcome to the Replace Utility");
        System.out.println("Enter your input in the following format: Replace [-b] [-f] [-l] [-i] <from> <to> -- <filename> [<filename>] ");


        BufferedReader inputCommand = new BufferedReader(
                new InputStreamReader(System.in));

        String inputs = null;
        try {
            inputs = inputCommand.readLine();
            for(int i =0; i < inputs.length();++i){
                args[i] = inputs;
            }


        } catch (IOException e) {
            usage();//e.printStackTrace();
        }
            CommandOptions cmdOptions  = new CommandOptions();
            cmdOptions.parseCommandOptions(args);



    }

    private static void usage() {
        System.err.println("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- " + "<filename> [<filename>]*" );
    }

}