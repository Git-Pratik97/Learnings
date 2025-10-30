package binarySearchTree;

public class SearchInBST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrderTravel(Node root){
        if(root == null){
            return;
        }

        inOrderTravel(root.left);
        System.out.print(root.data + " ");
        inOrderTravel(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data > key){
            return search(root.left, key);
        }

        else if(root.data == key){
            return true;
        }

        else{
            return search(root.right, key);
        }

    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int num : values){
            root = insert(root, num);
        }

        inOrderTravel(root);

        if(search(root, 4)){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");
        }


    }
}
