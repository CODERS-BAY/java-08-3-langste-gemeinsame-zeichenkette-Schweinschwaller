import java.util.Scanner;

public class LongestCommonString {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String strOne = "";
        String strTwo = "";
        System.out.print("First input: ");
        strOne = s.nextLine();
        System.out.print("Last input: ");
        strTwo = s.nextLine();

        //TEST
        /*
        strOne = "AGTCCGTCAAAGT";
        strTwo = "AGTGACCCGTCAACC";

        strOne = "123456789Hallo";
        strTwo = "Hallo987654321";
        */
        System.out.println();
        System.out.println(strOne);
        System.out.println(strTwo);

        // i used uppercase for fast testing
        if (strOne.length() < strTwo.length()) {
            System.out.println(findLCS(strTwo.toUpperCase(), strOne.toUpperCase()));
        } else {
            System.out.println(findLCS(strOne.toUpperCase(), strTwo.toUpperCase()));
        }
    }

    public static String findLCS(String strOneLonger, String strTwo) {
        // if one of the Strings empty it returns an empty String
        if (strOneLonger.isEmpty() || strTwo.isEmpty()) {
            return "";
        }
        // saves the longest common string that found
        String result = "";
        // a String to compare
        String help = "";
        // StepForward notices the start position of the compare
        for (int i = 0, stepForward = 0; i < strOneLonger.length(); i++) {
            // add next char of the string in the compare string help
            help += strOneLonger.charAt(i);

            if (!strTwo.contains(help)) {
                // the help string is not compare to the strTwo
                if (help.length() > result.length()) {
                    // result --> the last longest common string is in the result
                    // if u want the first longest common string u have to put the substring out of the if
                    result = help.substring(0, help.length() - 1);
                    // StepForward +1 and the for loop start again bei the next letter
                    i = stepForward++;
                }
                // reset the help string for the next comparison
                help = "";
            }
        }
        // if the compare part at the end of the String
        if (help.length() > result.length()) {
            result = help;
        }
        return result;
    }
}