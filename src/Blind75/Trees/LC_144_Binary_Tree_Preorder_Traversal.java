package Blind75.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_144_Binary_Tree_Preorder_Traversal {
    static class TreeNode {
        int val;
        Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode left;
        Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode left, Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // Input: root = [1,null,2,3]
        Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode root = new Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode(1, null, new Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode(2, new Blind75.Trees.LC_144_Binary_Tree_Preorder_Traversal.TreeNode(3), null));

        // Create a solution object
        LC_144_Binary_Tree_Preorder_Traversal solution = new LC_144_Binary_Tree_Preorder_Traversal();

        // Execute preorderTraversal method
        List<Integer> result = solution.preorderTraversal(root);

        // Print the result
        System.out.println(result);
    }
}
