package amazon.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FirstMissingInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(firstMissingPositive(A));
    }

    private static int firstMissingPositive(ArrayList<Integer> A) {
        int min = 1;
        Collections.sort(A);
        for (Integer a : A) {
            if (a == min) {
                min++;
            }
        }
        return min;
    }
}
