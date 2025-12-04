package treeTest;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] arr){
            index++;
            if(arr[index] == -1){
                return null;
            }

            Node newNode = new Node(arr[index]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);

            return newNode;
        }
    }

    public static int countNodesTree(Node root){
        if(root == null){
            return 0;
        }

        int left = countNodesTree(root.left);
        int right = countNodesTree(root.right);

        return left + right + 1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }

        int leftdia = diameterOfTree(root.left);
        int rightdia = diameterOfTree(root.right);
        int currdia = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(currdia, Math.max(leftdia, rightdia));
    }

    public static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo calculDiameter(Node root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = calculDiameter(root.left);
        TreeInfo right = calculDiameter(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int dia1 = left.diameter;
        int dia2 = right.diameter;
        int dia3 = left.height + right.height + 1;

        int diameter = Math.max(Math.max(dia1, dia2), dia3);

        TreeInfo newTreeInfo = new TreeInfo(height,diameter);

        return newTreeInfo;

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        List<Integer> list1 = Arrays.stream(nodes)
                        .boxed()
                                .toList();

        System.out.println(Collections.frequency(list1, -1));

        System.out.println("Root of the tree : " + root.data);

        System.out.println("Number of Nodes in the given tree : " + countNodesTree(root));

        System.out.println("Sum of all the nodes in the tree : " + sumOfNodes(root));

        System.out.println("Height of the given tree : " + heightOfTree(root));

        System.out.println("Max diameter of the tree is : " + diameterOfTree(root));


        System.out.println("Max Diameter of the tree using TreeInfo : " + calculDiameter(root).diameter);
    }
}
