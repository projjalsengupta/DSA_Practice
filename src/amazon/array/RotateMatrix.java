package amazon.array;

import java.util.ArrayList;
import java.util.Scanner;

/*
Input
1  2  3  4  5
6  7  8  9  10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
Output
21 16 11 6  1
22 17 12 7  2
23 18 13 8  3
24 19 14 9  4
25 20 15 10 5
Rotate by dividing into 4 parts
i)
1 -> 5
5 -> 25
25 -> 21
21 -> 1
ii)
2 -> 10
10 -> 24
24 -> 16
16 -> 2
iii)
6 -> 4
4 -> 20
20 -> 22
22 -> 6
and so on...
Which means
i)
n = 5, x = 0, y = 0
(0, 0) is (0, 4) --> (y, n - 1 - x) = (x, y)
(0, 4) is (4, 4) --> (n - 1 - x, n - 1 - y) = (y, n - 1)
(4, 4) is (4, 0) --> (n - 1 - y, x) = (n - 1 - x, n - 1 - y)
(4, 0) is (0, 0) --> (x, y) = (n - 1 - y, x)
ii)
n = 5, x = 0, y = 1
(0, 1) is (1, 4) --> (y, n - 1 - x) = (x, y)
(1, 4) is (4, 3) --> (n - 1 - x, n - 1 - y) = (y, n - 1)
(4, 3) is (3, 0) --> (n - 1 - y, x) = (n - 1 - x, n - 1 - y)
(3, 0) is (0, 1) --> (x, y) = (n - 1 - y, x)
iii)
n = 5, x = 1, y = 0
(1, 0) is (0, 3) --> (y, n - 1 - x) = (x, y)
(0, 3) is (3, 4) --> (n - 1 - x, n - 1 - y) = (y, n - 1)
(3, 4) is (4, 1) --> (n - 1 - y, x) = (n - 1 - x, n - 1 - y)
(4, 1) is (1, 0) --> (x, y) = (n - 1 - y, x)
and so on...
*/

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
