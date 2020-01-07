package microsoft.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivisibleBy3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String seq = br.readLine();
            System.out.println(isDivisibleBy3(seq));
        }
    }

    private static int isDivisibleBy3(String seq) {
        long[] arr = new long[2];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '1') {
                arr[i % 2]++;
            }
        }
        return Math.abs(arr[0] - arr[1]) % 3 == 0 ? 1 : 0;
    }
}
