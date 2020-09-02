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

//Test        int testCount = 0;
        int jmp = 0;
        for (int i = 0; i < strOneLonger.length(); i++) {
//Test            testCount++;
            if (!strTwo.contains(help)) {
                if (help.length() > result.length()) {
                    result = help.substring(0, help.length() - 1);
                    i = ++jmp;
                }
                help = "";
            }
            help += strOneLonger.charAt(i);
        }
        /*
        for (int i = 0; i < strOneLonger.length(); i++) {
            help = "";
            for (int j = i; j < strOneLonger.length(); j++) {
                testCount++;
                help += strOneLonger.charAt(j);
                if (!strTwo.contains(help)) {
                    if (help.length() - 1 > result.length()) {
                        result = help.substring(0, help.length() - 1);
                        break;
                    }
                    help = "";
                }
            }
            if (strOneLonger.length() - i < result.length()) {
                break;
            }
        }*/
//Test        System.out.println("\nSchleifendurchläufe: " + testCount + "\n");

        if (result.length() > 2) {
            return result;
        } else {
            return "No match";
        }
    }
}