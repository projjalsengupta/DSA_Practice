package Amazon.Array;

import java.util.*;

public class SpiralOrderMatrixOne {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < m; i++) {
            a.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                a.get(i).add(sc.nextInt());
            }
        }
        print((spiralOrder(a)));
    }

    private static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int er = A.size();
        int ec = A.get(0).size();
        int sr = 0;
        int sc = 0;
        while (sr < er && sc < ec) {
            for (int i = sc; i < ec; i++) {
                res.add(A.get(sr).get(i));
            }
            sr++;
            for (int i = sr; i < er; i++) {
                res.add(A.get(i).get(ec - 1));
            }
            ec--;
            if (sr < er) {
                for (int i = ec - 1; i >= sc; i--) {
                    res.add(A.get(er - 1).get(i));
                }
                er--;
            }
            if (sc < ec) {
                for (int i = er - 1; i >= sr; i--) {
                    res.add(A.get(i).get(sc));
                }
                sc++;
            }
        }
        return res;
    }

    private static void print(ArrayList<Integer> a) {
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
