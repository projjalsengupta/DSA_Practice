package microsoft.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[26];
            Queue<Character> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char ch = st.nextToken().charAt(0);
                if (!visited[ch - 'a']) {
                    visited[ch - 'a'] = true;
                    q.add(ch);
                } else {
                    q.remove(ch);
                }
                if (!q.isEmpty()) {
                    System.out.print(q.peek() + " ");
                } else {
                    System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
    }
}
