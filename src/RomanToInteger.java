import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        System.out.println(romanToInt(A));
    }

    private static int romanToInt(String A) {
        HashMap<String, Integer> romanHash = new HashMap<>();
        romanHash.put("I", 1);
        romanHash.put("IV", 4);
        romanHash.put("V", 5);
        romanHash.put("IX", 9);
        romanHash.put("X", 10);
        romanHash.put("XL", 40);
        romanHash.put("L", 50);
        romanHash.put("XC", 90);
        romanHash.put("C", 100);
        romanHash.put("CD", 400);
        romanHash.put("D", 500);
        romanHash.put("CM", 900);
        romanHash.put("M", 1000);

        int ans = 0;

        for (int i = 0; i < A.length(); i++) {
            if (i < A.length() - 1 && romanHash.containsKey(A.substring(i, i + 2))) {
                ans += romanHash.get(A.substring(i, i + 2));
                i++;
            } else if (romanHash.containsKey(A.substring(i, i + 1))) {
                ans += romanHash.get(A.substring(i, i + 1));
            }
        }

        return ans;
    }
}
