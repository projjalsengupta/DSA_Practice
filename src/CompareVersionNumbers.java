import java.math.BigInteger;
import java.util.Scanner;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        System.out.println(compareVersion(A, B));
    }

    private static int compareVersion(String A, String B) {
        String[] partsA = A.split("[.]");
        String[] partsB = B.split("[.]");
        int len = Math.max(partsA.length, partsB.length);
        for (int i = 0; i < len; i++) {
            if (i < partsA.length && i < partsB.length) {
                BigInteger aVal = new BigInteger(partsA[i]);
                BigInteger bVal = new BigInteger(partsB[i]);
                int res = aVal.compareTo(bVal);
                if (res != 0) {
                    return res;
                }
            } else if (i < partsA.length) {
                BigInteger aVal = new BigInteger(partsA[i]);
                if (!aVal.equals(new BigInteger("0"))) {
                    return 1;
                }
            } else {
                BigInteger bVal = new BigInteger(partsB[i]);
                if (!bVal.equals(new BigInteger("0"))) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
