import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountNumberOfAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String query = br.readLine();
            System.out.println(countAnagrams(line, query));
        }
    }

    private static int countAnagrams(String line, String query) {
        HashMap<Character, Integer> queryMap = new HashMap<>();
        for (char ch : query.toCharArray()) {
            addChar(queryMap, ch);
        }
        HashMap<Character, Integer> lineMap = new HashMap<>();
        for (int i = 0; i < query.length(); i++) {
            char ch = line.charAt(i);
            addChar(lineMap, ch);
        }
        int count = 0;
        if (queryMap.equals(lineMap)) {
            count++;
        }
        for (int i = query.length(); i < line.length(); i++) {
            removeChar(lineMap, line.charAt(i - query.length()));
            addChar(lineMap, line.charAt(i));
            if (queryMap.equals(lineMap)) {
                count++;
            }
        }
        return count;
    }

    private static void addChar(HashMap<Character, Integer> map, char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    private static void removeChar(HashMap<Character, Integer> map, char ch) {
        if (map.containsKey(ch)) {
            int val = map.get(ch);
            if (val > 1) {
                map.put(ch, val - 1);
            } else {
                map.remove(ch);
            }
        }
    }
}