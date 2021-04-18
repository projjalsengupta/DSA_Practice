import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchDict {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> dict = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                dict.add(br.readLine());
            }
            String pattern = br.readLine();
            System.out.println(searchString(dict, pattern));
            System.out.println(searchSubstring(dict, pattern));
        }
    }

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean endOfWord = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode it = root;
            for (char ch : word.toCharArray()) {
                if (!it.map.containsKey(ch)) {
                    it.map.put(ch, new TrieNode());
                }
                it = it.map.get(ch);
            }
            it.endOfWord = true;
        }

        boolean searchSubstring(String word) {
            TrieNode it = root;
            for (char ch : word.toCharArray()) {
                if (it.map.containsKey(ch)) {
                    it = it.map.get(ch);
                } else {
                    return false;
                }
            }
            return true;
        }

        boolean searchString(String word) {
            TrieNode it = root;
            for (char ch : word.toCharArray()) {
                if (it.map.containsKey(ch)) {
                    it = it.map.get(ch);
                } else {
                    return false;
                }
            }
            return it.endOfWord;
        }
    }

    private static boolean searchString(ArrayList<String> dict, String pattern) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        return trie.searchString(pattern);
    }

    private static boolean searchSubstring(ArrayList<String> dict, String pattern) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        return trie.searchSubstring(pattern);
    }
}
