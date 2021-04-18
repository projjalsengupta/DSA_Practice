import java.util.ArrayList;
import java.util.Scanner;

public class RotateMatrix {
    private static void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = a.get(x).get(y);
                a.get(x).set(y, a.get(n - 1 - y).get(x));
                a.get(n - 1 - y).set(x, a.get(n - 1 - x).get(n - 1 - y));
                a.get(n - 1 - x).set(n - 1 - y, a.get(y).get(n - 1 - x));
                a.get(y).set(n - 1 - x, temp);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                a.get(i).add(sc.nextInt());
            }
        }
        rotate(a);
        print(a);
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
