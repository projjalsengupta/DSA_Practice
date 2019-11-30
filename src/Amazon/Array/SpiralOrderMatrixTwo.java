package Amazon.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralOrderMatrixTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print((spiralOrder(n)));
    }

    private static ArrayList<ArrayList<Integer>> spiralOrder(int A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                list.add(0);
            }
            res.add(list);
        }
        int er = A;
        int ec = A;
        int sr = 0;
        int sc = 0;
        int c = 0;
        while (sr < er && sc < ec) {
            for (int i = sc; i < ec; i++) {
                res.get(sr).set(i, ++c);
            }
            sr++;
            for (int i = sr; i < er; i++) {
                res.get(i).set(ec - 1, ++c);
            }
            ec--;
            if (sr < er) {
                for (int i = ec - 1; i >= sc; i--) {
                    res.get(er - 1).set(i, ++c);
                }
                er--;
            }
            if (sc < ec) {
                for (int i = er - 1; i >= sr; i--) {
                    res.get(i).set(sc, ++c);
                }
                sc++;
            }
        }
        return res;
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (ArrayList<Integer> integers : a) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
