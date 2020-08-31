import java.util.Scanner;

public class LongestCommonString {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("First input: ");
        String strOne = s.nextLine();
        System.out.print("Last input: ");
        String strTwo = s.nextLine();

        //TEST
        //String strOne = "AGTCCGTCAAAGT";
        //String strTwo = "AGTGACCCGTCAACC";

        if (strOne.length() < strTwo.length()) {
            System.out.println(findLCS(strTwo.toUpperCase(), strOne.toUpperCase()));
        } else {
            System.out.println(findLCS(strOne.toUpperCase(), strTwo.toUpperCase()));
        }
    }

    public static String findLCS(String strOneLonger, String strTwo) {

        if (strOneLonger.isEmpty() || strTwo.isEmpty()) {
            return "";
        }

        String result = " ";
        String help = "";

        // --> left to rigth
        int jmp = 0;
        for (int i = 0; i < strOneLonger.length(); i++) {
            if (!strTwo.contains(help)) {
                if (help.length() > result.length()) {
                    result = help;
                    help = "";
                    i = ++jmp;
                }
            }
            help += strOneLonger.charAt(i);
        }

        if (result.length() > 2) {
            // the last sign in the string is to much
            return result.substring(0, result.length() - 1);
        } else {
            return "No match";
        }
    }
}