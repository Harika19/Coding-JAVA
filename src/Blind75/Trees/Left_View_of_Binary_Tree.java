package Blind75.Trees;

import java.util.ArrayList;
import java.util.List;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Left_View_of_Binary_Tree
{

    private ArrayList<Integer> logic(Node root, int level, ArrayList<Integer> arr){
        if(root == null) return arr;
        if(arr.size()==level){
            arr.add(root.data);
        }
        logic(root.left, level+1, arr);
        logic(root.right, level+1, arr);
        return arr;
    }

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Left_View_of_Binary_Tree obj = new Left_View_of_Binary_Tree();
        return obj.logic(root, 0, arr);
    }

    public static void main(String[] args) {
        // Create a sample binary tree

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Create an instance of the Solution class
        Left_View_of_Binary_Tree obj = new Left_View_of_Binary_Tree();

        // Perform postorder traversal and print the result
        List<Integer> result = obj.leftView(root);
        System.out.println("leftView " + result);
    }
}


