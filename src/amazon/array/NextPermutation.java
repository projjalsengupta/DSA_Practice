package amazon.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(nextPermutation(A));
    }

    private static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int index = -1;
        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i) > A.get(i - 1)) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            Collections.sort(A);
        } else {
            int sIndex = -1;
            for (int j = A.size() - 1; j > index; j--) {
                if (A.get(j) > A.get(index)) {
                    sIndex = j;
                    break;
                }
            }
            Collections.swap(A, index, sIndex);
            Collections.sort(A.subList(index + 1, A.size()));
        }
        return A;
    }
}
