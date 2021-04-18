import java.util.Scanner;

public class DecodeThePattern {
    private static void printLine(int n) {
        if (n == 0) {
            return;
        }
        String currentLine = new String("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char ch = currentLine.charAt(0);
            for (int j = 1; j < currentLine.length(); j++) {
                if (currentLine.charAt(j) != ch) {
                    sb.append(count);
                    sb.append(ch);
                    ch = currentLine.charAt(j);
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count);
            sb.append(ch);
            currentLine = sb.toString();
        }
        System.out.println(currentLine);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            printLine(n);
        }
    }
}
