package microsoft.misc;

import java.util.Scanner;

public class URLShortener {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        while (t-- > 0) {
            int id = scanner.nextInt();
            String url = convertToBase62(id, base62);
            System.out.println(url);
            System.out.println(decodeBase62(url, base62));
        }
    }

    private static String convertToBase62(int id, String base62) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(base62.charAt(id % 62));
            id /= 62;
        }
        return sb.reverse().toString();
    }

    private static int decodeBase62(String url, String base62) {
        int power = url.length() - 1;
        int id = 0;
        for (char ch : url.toCharArray()) {
            id += base62.indexOf(ch) * Math.pow(62, power--);
        }
        return id;
    }
}
