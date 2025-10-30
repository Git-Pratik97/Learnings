package treeTest;


public class PreOrderTraverse {
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

    public static class BinaryTree{
        static int index = -1;
        public Node buildTreePreOrder(int[] arr){
            index++;
            if(arr[index] == -1){
                return null;
            }

            Node newNode = new Node(arr[index]);
            newNode.left = buildTreePreOrder(arr);
            newNode.right = buildTreePreOrder(arr);

            return newNode;
        }
    }

    public static void preOrderTravel(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    public static void inOrderTravel(Node root){
        if(root == null){
            return;
        }

        inOrderTravel(root.left);
        System.out.print(root.data + " ");
        inOrderTravel(root.right);

    }

    public static void postOrderTravel(Node root){
        if(root == null){
            return;
        }

        postOrderTravel(root.left);
        postOrderTravel(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
//        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        int[] nodes1 = {1,2,3,-1,-1,4,5};
//        BinaryTree tree = new BinaryTree();
//        Node root = tree.buildTreePreOrder(nodes);
//
        BinaryTree tree1 = new BinaryTree();
        Node root1 = tree1.buildTreePreOrder(nodes1);

//        System.out.println("Root of the tree : " + root.data);
//
//        preOrderTravel(root);
//        System.out.println(" ");
//
//        inOrderTravel(root);
//        System.out.println(" ");
//        postOrderTravel(root);

        inOrderTravel(root1);
        System.out.println();


    }
}
