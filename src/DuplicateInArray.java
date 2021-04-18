import java.util.*;

public class DuplicateInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(repeatedNumber(A));
    }

    private static int repeatedNumber(final List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer a : A) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            int count = (int) ((Map.Entry) mapEntry).getValue();
            if (count > 1) {
                return ((int) ((Map.Entry) mapEntry).getKey());
            }
        }
        return -1;
    }
}
