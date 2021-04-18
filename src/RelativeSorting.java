import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RelativeSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(tokenizer.nextToken());
            int n2 = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr1 = new ArrayList<>();
            for (int i = 0; i < n1; i++) {
                arr1.add(Integer.parseInt(tokenizer.nextToken()));
            }
            tokenizer = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr2 = new ArrayList<>();
            for (int i = 0; i < n2; i++) {
                arr2.add(Integer.parseInt(tokenizer.nextToken()));
            }
            printArrayList(relativeSort(arr1, arr2));
        }
    }

    private static ArrayList<Integer> relativeSort(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Collections.sort(arr1);
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : arr2) {
            set.add(i);
            if (map.containsKey(i)) {
                for (int j = 0; j < map.get(i); j++) {
                    res.add(i);
                }
            }
        }
        for (int i : arr1) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static void printArrayList(ArrayList<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
