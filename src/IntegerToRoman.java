import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        System.out.println(intToRoman(A));
    }

    private static String intToRoman(int A) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] romanVal = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        for (int i = romanVal.length - 1; i >= 0; i--) {
            int res = A / romanVal[i];
            A = A % romanVal[i];
            while (res-- > 0) {
                stringBuilder.append(roman[i]);
            }
        }
        return stringBuilder.toString();
    }
}
