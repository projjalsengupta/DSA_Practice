import java.util.ArrayList;
import java.util.Scanner;

public class ValidIPAddresses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(restoreIpAddresses(A));
    }

    private static ArrayList<String> restoreIpAddresses(String A) {
        if (A.length() < 4 || A.length() > 12) {
            return new ArrayList<>();
        }
        return convert(A);
    }

    private static ArrayList<String> convert(String s) {
        ArrayList<String> addresses = new ArrayList<>();
        for (int i = 0; i < s.length() - 3; i++) {
            for (int j = i + 1; j < s.length() - 2; j++) {
                for (int k = j + 1; k < s.length() - 1; k++) {
                    String newStr = s.substring(0, i + 1) + ".";
                    newStr += s.substring(i + 1, j + 1) + ".";
                    newStr += s.substring(j + 1, k + 1) + "." + s.substring(k + 1);
                    if (isValid(newStr)) {
                        addresses.add(newStr);
                    }
                }
            }
        }
        return addresses;
    }

    private static boolean isValid(String ip) {
        String[] parts = ip.split("[.]");
        for (String part : parts) {
            int intPart = Integer.parseInt(part);
            if (!String.valueOf(intPart).equals(part)) {
                return false;
            }
            if (intPart < 0 || intPart > 255) {
                return false;
            }
        }
        return true;
    }
}
