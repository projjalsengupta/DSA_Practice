import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WaveArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        print(wave(A));
    }

    private static ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size(); i += 2) {
            if (i > 0 && A.get(i - 1) > A.get(i)) {
                Collections.swap(A, i, i - 1);
            }
            if (i < A.size() - 1 && A.get(i) < A.get(i + 1)) {
                Collections.swap(A, i, i + 1);
            }
        }
        return A;
    }

    private static void print(ArrayList<Integer> A) {
        for (Integer integer : A) {
            System.out.println(integer + " ");
        }
        System.out.println();
    }
}
