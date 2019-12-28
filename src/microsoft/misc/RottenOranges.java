package microsoft.misc;

import java.util.Scanner;

public class RottenOranges {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] mat = new int[r][c];
            int oneCount = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = scanner.nextInt();
                    if (mat[i][j] == 1) {
                        oneCount++;
                    }
                }
            }
            System.out.println(minimumTime(mat, oneCount));
        }
    }

    public static int minimumTime(int[][] mat, int oneCount) {
        int time = 0;
        while (oneCount > 0) {
            int prevCount = oneCount;
            int[][] tempMat = new int[mat.length][mat[0].length];
            copyMat(mat, tempMat);
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    if (tempMat[i][j] == 2) {
                        if (i > 0 && tempMat[i - 1][j] == 1) {
                            mat[i - 1][j] = 2;
                            oneCount--;
                        }
                        if (j > 0 && tempMat[i][j - 1] == 1) {
                            mat[i][j - 1] = 2;
                            oneCount--;
                        }
                        if (i < tempMat.length - 1 && tempMat[i + 1][j] == 1) {
                            mat[i + 1][j] = 2;
                            oneCount--;
                        }
                        if (j < tempMat[i].length - 1 && tempMat[i][j + 1] == 1) {
                            mat[i][j + 1] = 2;
                            oneCount--;
                        }
                    }
                }
            }
            if (prevCount == oneCount) {
                return -1;
            }
            time++;
        }
        return time;
    }

    public static void copyMat(int[][] mat1, int[][] mat2) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                mat2[i][j] = mat1[i][j];
            }
        }
    }
}
