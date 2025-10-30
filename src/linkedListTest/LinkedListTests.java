package linkedListTest;

public class LinkedListTests {

    Node head;

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    //Insertion addFirst and addLast
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;

    }

    //Deleting from Linked List
    public void deleteFirst(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }

        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node last = head.next;

        while(last.next != null){
            secondLast = secondLast.next;
            last = last.next;
        }
        secondLast.next = null;
    }

    public void printLinkedList(){
        if(head == null){
            System.out.println(" Null ");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;

        }
        System.out.println(" Null ");

    }

    public static void main(String[] args) {
        LinkedListTests list = new LinkedListTests();
        list.addFirst("is");
        list.addFirst("This");

        list.printLinkedList();

        list.addLast("a");
        list.addLast("Linked List");
        list.addLast("test");

        list.printLinkedList();
    }
}
