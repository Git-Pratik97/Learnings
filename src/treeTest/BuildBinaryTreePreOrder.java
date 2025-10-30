package treeTest;

public class BuildBinaryTreePreOrder {

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

    public static class BinaryTree{
        static int index = -1;
        public Node buildTree(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void main(String[] args) {
         int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

         int[] preorder = {3, 9, 20, 15, 7};
//         BinaryTree tree = new BinaryTree();
//         Node root = tree.buildTree(nodes);

         BinaryTree tree2 = new BinaryTree();
         Node root2 = tree2.buildTree(preorder);

        System.out.println("Root of the tree : " + root2.data);
    }
}
