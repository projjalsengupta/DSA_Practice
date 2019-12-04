package amazon.tree;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution solution = new Solution(root);
        while (solution.hasNext()) {
            System.out.println(solution.next());
        }
    }

    public static class Solution {

        TreeNode root;
        ArrayList<Integer> list = new ArrayList<>();
        int next = 0;

        Solution(TreeNode root) {
            this.root = root;
            inorder();
        }

        /**
         * @return whether we have a next smallest number
         */
        boolean hasNext() {
            return next < list.size();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(next++);
        }

        private void inorder() {
            TreeNode temp = root;
            Stack<TreeNode> s = new Stack<>();
            while (temp != null || !s.isEmpty()) {
                while (temp != null) {
                    s.push(temp);
                    temp = temp.left;
                }
                temp = s.pop();
                list.add(temp.val);
                temp = temp.right;
            }
        }
    }
}
