package testingCode;

import treeTest.BuildBinaryTreePreOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,null,null,null,5};

        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.Node root = binaryTree.buildTreeWithLevelOrder(arr);

        List<Integer> result = rightSideViewBinaryTree(root);

        System.out.println(result);


    }

    public static List<Integer> rightSideViewBinaryTree(BinaryTree.Node root){
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();

            int lastVal = 0;

            for(int i = 0; i < queueSize; i++){
                BinaryTree.Node curr = queue.poll();
                lastVal = curr.value;

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            res.add(lastVal);
        }
        return res;
    }



}

class BinaryTree{
    public Node buildTreeWithLevelOrder(Integer[] arr){
        if(arr == null || arr.length == 0 || arr[0] == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr[0]);
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty() && i < arr.length) {
            Node curr = queue.poll();

            if(i < arr.length && arr[i] != null){
                curr.left = new Node(arr[i]);
                queue.offer(curr.left);
            }
            i++;

            if(i < arr.length && arr[i] != null){
                curr.right = new Node(arr[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}


