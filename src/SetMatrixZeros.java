import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetMatrixZeros {
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
        setMatrixZeros(a);
        print(a);
    }

    private static void setMatrixZeros(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (row.contains(i) || col.contains(j)) {
                    a.get(i).set(j, 0);
                }
            }
        }
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
