import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        System.out.println(largestNumber(A));
    }

    private static String largestNumber(List<Integer> A) {
        List<String> AStr = new ArrayList<>();
        if (Collections.frequency(A, 0) == A.size()) {
            return "0";
        }
        for (Integer a : A) {
            AStr.add(String.valueOf(a));
        }
        AStr.sort((s, t1) -> (s + t1).compareTo(t1 + s));
        Collections.reverse(AStr);
        StringBuilder s = new StringBuilder();
        for (String str : AStr) {
            s.append(str);
        }
        return s.toString();
    }
}
