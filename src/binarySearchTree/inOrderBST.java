package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class inOrderBST {
    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }

        List<Integer> list = new ArrayList<>();
        inOrderBST(root, list);

        List<Integer> returnedList = inOrderList(root, new ArrayList<>());

        System.out.println("Using void method" + list);

        System.out.println();

        System.out.println("Using returned List" + returnedList);
    }

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.val > val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrderBST(Node root, List<Integer> nums){
        if(root == null){
            return;
        }

        nums.add(root.val);
        inOrderBST(root.left, nums);
        inOrderBST(root.right, nums);

//        inOrderBST(root.left, nums);
//        nums.add(root.val);
//        inOrderBST(root.right, nums);
    }

    public static List<Integer> inOrderList(Node root, List<Integer> nums){
        if(root == null){
            return nums;
        }

        nums.add(root.val);
        inOrderBST(root.left, nums);
        inOrderBST(root.right, nums);

        return nums;

//        inOrderBST(root.left, nums);
//        nums.add(root.val);
//        inOrderBST(root.right, nums);
    }
}
