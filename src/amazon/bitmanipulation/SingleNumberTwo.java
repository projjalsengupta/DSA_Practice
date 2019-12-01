package amazon.bitmanipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleNumberTwo {
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
        int result = 0;
        int x, sum;
        for (int i = 0; i < 32; i++) {
            sum = 0;
            x = (1 << i);
            for (Integer integer : A) {
                if ((integer & x) == 0)
                    sum++;
            }
            if ((sum % 3) == 0) {
                result |= x;
            }
        }
        return result;
    }
}
