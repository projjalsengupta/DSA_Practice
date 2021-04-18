import java.util.*;

public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextLine());
        }
        System.out.println(anagrams(A));
    }

    private static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        int n = A.size();
        for (int i = 0; i < n; i++) {
            char[] arr = A.get(i).toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if (map.get(str) != null) {
                map.get(str).add(i + 1);
            } else {
                ArrayList<Integer> g = new ArrayList<>();
                g.add(i + 1);
                map.put(str, g);
            }
        }
        return new ArrayList<>(map.values());
    }
}
