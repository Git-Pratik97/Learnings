package treeTest;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BuildTreePreorderInorder {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        Deque<Integer> dequePreOrder = new ArrayDeque<>();
        for(int i = 0; i < preorder.length; i++){
            dequePreOrder.offer(preorder[i]);
        }

        buildTree(dequePreOrder, inorder);
    }

    public static Node buildTree(Deque<Integer> preorder, int[] inorder){
        if(inorder.length > 0){
            int idx = indexOf(inorder, preorder.poll());
            Node root = new Node(inorder[idx]);
//            System.out.println("root -> " + "left".repeat(idx));
            root.left = buildTree(preorder, Arrays.copyOfRange(inorder, 0, idx));
            System.out.println("root -> " + "left".repeat(idx) + (root.left != null ? root.left.data : -1));
            root.right = buildTree(preorder, Arrays.copyOfRange(inorder, idx + 1, inorder.length));
            System.out.println("root -> " + "right".repeat(idx) + (root.right != null ? root.left.data : -1));

            return root;
        }
        return null;
    }

    public static int indexOf(int[] inorder, int val){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}
