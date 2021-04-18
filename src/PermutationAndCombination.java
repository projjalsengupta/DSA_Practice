import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PermutationAndCombination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        Set<String> set = new HashSet<>();
        Map<Integer, Set<int[]>> map = new HashMap<>();

        combinationAndPermutation(string, "", 0, set, map);

        for (String str : set) {
            System.out.println(str);
        }
    }

    private static void combinationAndPermutation(String string, String prev, int index, Set<String> set, Map<Integer, Set<int[]>> map) {
        if (index >= string.length()) {
            return;
        }
        Set<int[]> permutationSet;
        if (map.containsKey(prev.length())) {
            permutationSet = map.get(prev.length());
        } else {
            permutationSet = new HashSet<>();
            int[] arr = new int[prev.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            permutation(arr, 0, prev.length() - 1, permutationSet);
            map.put(prev.length(), permutationSet);
        }
        Set<String> stringPermutationSet = generateAllPermutationsOfString(prev, permutationSet);
        for (String str : stringPermutationSet) {
            set.add(str + string.charAt(index));
        }
        combinationAndPermutation(string, prev, index + 1, set, map);
        combinationAndPermutation(string, prev + string.charAt(index), index + 1, set, map);
    }

    private static void permutation(String arr, int left, int right, Set<int[]> set) {
        if (left == right) {
            set.add(arr.clone());
        } else {
            for (int i = left; i <= right; i++) {
                swap(arr, left, i);
                permutation(arr, left + 1, right, set);
                swap(arr, left, i);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static Set<String> generateAllPermutationsOfString(String string, Set<int[]> permutationSet) {
        Set<String> stringPermutationSet = new HashSet<>();
        for (int[] permutation : permutationSet) {
            StringBuilder sb = new StringBuilder();
            for (int i : permutation) {
                sb.append(string.charAt(i));
            }
            stringPermutationSet.add(sb.toString());
        }
        return stringPermutationSet;
    }
}
