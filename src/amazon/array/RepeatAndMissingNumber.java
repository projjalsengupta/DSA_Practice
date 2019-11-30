package amazon.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatAndMissingNumber {
    private static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        byte[] countMap = new byte[A.size()];
        for (Integer a : A) {
            countMap[a - 1]++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int a = -1;
        int b = -1;
        for (int i = 0; i < countMap.length; i++) {
            if (countMap[i] == 0) {
                b = i + 1;
            } else if (countMap[i] == 2) {
                a = i + 1;
            }
        }
        result.add(a);
        result.add(b);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        print(repeatedNumber(A));
    }

    private static void print(ArrayList<Integer> A) {
        for (Integer a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
