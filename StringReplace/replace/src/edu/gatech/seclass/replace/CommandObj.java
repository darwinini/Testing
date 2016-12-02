package edu.gatech.seclass.replace;
import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;


public abstract class CommandObj{

    public CommandObj() {}
    public CommandObj(String[] args, int index)
    {


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

    private final List<StringReplacement> text_Replacement = Lists.newArrayList();
    {
        text_Replacement.add(new StringReplacement("\\", "\\backslashes "));
        for (final String x : ImmutableList.of("_", "^", "~", "$", "%", "#", "&", "{", "}")) {
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
