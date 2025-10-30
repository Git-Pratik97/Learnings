package testingCode;

public class LinkedListTest {

    Node head;
    private int size;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public int getSize(){
        return size;
    }

    public void reverseLinkedList(){
        if(head == null || head.next == null){
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while(curr != null){
            Node nextNode = curr.next;
            curr.next = prev;

            //update Node
            prev = curr;
            curr = nextNode;
        }
        head.next = null;
        head = prev;
    }

    public void addLast(int num){
        Node newNode = new Node(num);
        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void printLinkedList(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }

        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.print("Null\n");
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }



        Node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        Node curr = head;
        System.out.println("New Current Node : " + curr);
        return newNode;
    }

    public static void main(String[] args) {
        LinkedListTest list = new LinkedListTest();

        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        list.addLast(6);

        System.out.println("Original Linked List : ");
        list.printLinkedList();

        list.reverseLinkedList();

        System.out.println("Reversed Linked List : ");
        list.printLinkedList();

        list.head = list.reverseRecursive(list.head);
        System.out.println("Linked list afetr reverse Recursive : ");
        list.printLinkedList();



    }
}
