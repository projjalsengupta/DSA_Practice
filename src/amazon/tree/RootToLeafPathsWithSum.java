package amazon.tree;

import java.util.ArrayList;

public class RootToLeafPathsWithSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }

    private static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        if (A == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        pathSumUtil(A, B, 0, new ArrayList<>(), res);
        return res;
    }

    private static void pathSumUtil(TreeNode A, int B, int sum, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> sumPaths) {
        ArrayList<Integer> currentPath2 = new ArrayList<>(currentPath);
        currentPath2.add(A.val);
        sum += A.val;
        if (A.left == null && A.right == null) {
            if (sum == B) {
                sumPaths.add(currentPath2);
            }
        } else {
            if (A.left != null) {
                pathSumUtil(A.left, B, sum, currentPath2, sumPaths);
            }
            if (A.right != null) {
                pathSumUtil(A.right, B, sum, currentPath2, sumPaths);
            }
        }
    }
}
