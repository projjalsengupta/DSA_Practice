import java.util.Scanner;

public class NumDecodings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(numDecodings(s));
    }

    private static int numDecodings(String A) {
        if (A.startsWith("0")) {
            return 0;
        }
        int[] count = new int[A.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= A.length(); i++) {
            count[i] = 0;
            char cc = A.charAt(i - 1);
            char cp = A.charAt(i - 2);
            if ((int) cc > (int) '0') {
                count[i] = count[i - 1];
            }
            if (cp == '1' || (cp == '2' && cc < '7')) {
                count[i] += count[i - 2];
            }
        }
        return count[count.length - 1];
    }
}
