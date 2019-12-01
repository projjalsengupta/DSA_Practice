package amazon.bitmanipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(singleNumber(A));
    }

    private static int singleNumber(final List<Integer> A) {
        int num = 0;
        for (Integer integer : A) {
            num = num ^ integer;
        }
        return num;
    }
}
