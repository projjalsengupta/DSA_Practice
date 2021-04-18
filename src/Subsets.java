import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Subsets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokenizer.nextToken());
            }
            print(subsets(arr));
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        Arrays.sort(arr);
        Set<ArrayList<Integer>> set = new HashSet<>();
        subsetRecursive(arr, 0, set, new ArrayList<>());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>(set);
        lists.sort((list1, list2) -> {
            int i = 0;
            int j = 0;
            while (i < list1.size() && j < list2.size()) {
                int c = Integer.compare(list1.get(i++), list2.get(j++));
                if (c != 0) {
                    if (c > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
            if (i == list1.size() && j == list2.size()) {
                return 0;
            } else if (i == list1.size()) {
                return -1;
            } else {
                return 1;
            }
        });
        return lists;
    }

    private static void subsetRecursive(int[] arr, int index, Set<ArrayList<Integer>> lists, ArrayList<Integer> list) {
        lists.add(list);
        if (index >= arr.length) {
            return;
        }
        subsetRecursive(arr, index + 1, lists, list);
        ArrayList<Integer> newList = new ArrayList<>(list);
        newList.add(arr[index]);
        subsetRecursive(arr, index + 1, lists, newList);
    }

    private static void print(ArrayList<ArrayList<Integer>> lists) {
        for (ArrayList<Integer> list : lists) {
            System.out.print("(");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i < list.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print(")");
        }
        if (lists.isEmpty()) {
            System.out.print("Empty");
        }
        System.out.println();
    }
}
