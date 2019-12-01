package amazon.strings;

import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(lengthOfLastWord(A));
    }

    private static int lengthOfLastWord(String A) {
        int len = 0;
        boolean streakOfSpacesEnded = false;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) != ' ') {
                streakOfSpacesEnded = true;
            }
            if (streakOfSpacesEnded) {
                if (A.charAt(i) == ' ') {
                    break;
                }
                len++;
            }
        }
        return len;
    }
}
