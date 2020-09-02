import java.util.Scanner;

public class LongestCommonString {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("First input: ");
        String strOne = s.nextLine();
        System.out.print("Last input: ");
        String strTwo = s.nextLine();

        //TEST
//Test        String strOne = "AGTCCGTCAAAGT";
//Test        String strTwo = "AGTGACCCGTCAACC";

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

        for (int i = 0, stepForward = 0; i < strOneLonger.length(); i++) {
            if (!strTwo.contains(help)) {
                if (help.length() > result.length()) {
                    result = help.substring(0, help.length() - 1);
                    i = ++stepForward;
                }
                help = "";
            }
            help += strOneLonger.charAt(i);
        }

        if (result.length() > 2) {
            return result;
        } else {
            return "No match";
        }
    }
}