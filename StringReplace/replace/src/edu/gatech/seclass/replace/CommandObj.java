package edu.gatech.seclass.replace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class CommandObj {

    public CommandObj() {
    }

    public CommandObj(String[] args, int index) {


    }

    public CommandTypes.Type cmdType;

    public abstract void Process(LinkedList<String> fileNames);


    private class StringReplacement {

        final String replacementText;
        final String toReplace;


        StringReplacement(final String toReplace, final String replacementText) {
            this.toReplace = toReplace;
            this.replacementText = replacementText;
        }

        String replaceOn(final String input) {
            return input.replace(toReplace, replacementText);
        }

    }

    private final List<StringReplacement> text_Replacement = new ArrayList<>();

    {
        text_Replacement.add(new StringReplacement("\\", "\\backslashes "));

        String[] list = new String[]{"_", "^", "~", "$", "%", "#", "&", "{", "}"};

        for (final String x : list) {
            text_Replacement.add(new StringReplacement(x, "\\" + x));
        }
    }

    public String escapeOut(final String input) {
        String escapedOut = input;
        for (final StringReplacement replacementStr : text_Replacement) {
            escapedOut = replacementStr.replaceOn(escapedOut);
        }
        return escapedOut;
    }


}//end of Command class
