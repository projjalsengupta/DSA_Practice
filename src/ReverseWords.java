public class ReverseWords {
    public static void main(String[] args) {
        reverseWords("pqr.mono");
    }

    public static void reverseWords(String line) {
        String[] sd = line.split("[.]");
        int len = sd.length;
        for (int i = 0; i < len / 2; i++) {
            String temp = sd[i];
            sd[i] = sd[len - 1 - i];
            sd[len - 1 - i] = temp;
        }
        String res = "";
        for (String s : sd) {
            res += s + ".";
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
}
