package microsoft.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TicTacToe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[][] mat = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    mat[i][j] = st.nextToken().charAt(0);
                }
            }
            System.out.println((validate(mat) ? "Valid" : "Invalid"));
        }
    }

    private static boolean validate(char[][] mat) {
        int xCount = 0;
        int oCount = 0;
        for (char[] line : mat) {
            for (char c : line) {
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount == oCount || xCount == oCount + 1) {
            boolean xWon = getWon(mat, 'X');
            boolean oWon = getWon(mat, 'O');
            return (!xWon && !oWon) || (xWon && !oWon) || (!xWon && oWon && xCount == oCount);
        }
        return false;
    }

    private static boolean getWon(char[][] mat, char winChar) {
        int count = 0;
        boolean crossFlag = true;
        for (int i = 0; i < 3; i++) {
            if (mat[i][i] != winChar) {
                crossFlag = false;
                break;
            }
        }
        if (crossFlag) {
            return true;
        }
        crossFlag = true;
        for (int i = 2; i >= 0; i--) {
            if (mat[2 - i][i] != winChar) {
                crossFlag = false;
                break;
            }
        }
        if (crossFlag) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            boolean horizontalFlag = true;
            boolean verticalFlag = true;
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] != winChar) {
                    horizontalFlag = false;
                }
                if (mat[j][i] != winChar) {
                    verticalFlag = false;
                }
            }
            if (horizontalFlag) {
                return true;
            }
            if (verticalFlag) {
                return true;
            }
        }
        return false;
    }
}
