package Blind75.Trees;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC_145_Binary_Tree_Postorder_Traversal {
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    // Example usage
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Create an instance of the Solution class
        LC_145_Binary_Tree_Postorder_Traversal solution = new LC_145_Binary_Tree_Postorder_Traversal();

        // Perform postorder traversal and print the result
        List<Integer> result = solution.postorderTraversal(root);
        System.out.println("Postorder Traversal: " + result);
    }
}
