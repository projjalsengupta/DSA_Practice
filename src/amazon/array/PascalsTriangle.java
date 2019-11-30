package amazon.array;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        print(solve(n));
    }

    private static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i - 1 <= 0) {
                    list.add(1);
                } else {
                    int n = 0;
                    if (j < res.get(i - 1).size()) {
                        n += res.get(i - 1).get(j);
                    }
                    if (j - 1 >= 0) {
                        n += res.get(i - 1).get(j - 1);
                    }
                    list.add(n);
                }
            }
            res.add(list);
        }
        return res;
    }

    private static void print(ArrayList<ArrayList<Integer>> A) {
        for (ArrayList<Integer> integers : A) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
