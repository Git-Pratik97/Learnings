package binarySearchTree;

public class TreeTest {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int countLeafNode(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return countLeafNode(root.left)+countLeafNode(root.right);
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);

        System.out.println(countLeafNode(root));


    }
}
