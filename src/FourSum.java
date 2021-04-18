import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(scanner.nextInt());
        }
        int B = scanner.nextInt();
        System.out.println(fourSum(A, B));
    }

    private static ArrayList<ArrayList<Integer>> fourSum(final List<Integer> A, int B) {
        Collections.sort(A);
        Integer[] num = new Integer[A.size()];
        num = A.toArray(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > B) {
                        l--;
                    } else if (sum < B) {
                        k++;
                    } else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);

                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }

                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
