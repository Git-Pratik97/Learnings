package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LRUCache <T> {
    private final int capacity;
    private int size;
    private final Map<String, Node> map;
    private final DoublyLinkedList intenalQueue;

    LRUCache(final int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.intenalQueue = new DoublyLinkedList();
        this.size = 0;

    }

    public T get(final String key){
        Node node = map.get(key);
        if(node == null){
            return null;
        }

        intenalQueue.moveToTheFront(node);
        return map.get(key).value;

    }

    public void put(String key, final T value){
        Node currentNode = map.get(key);
        if(currentNode != null){
            currentNode.value = value;
            intenalQueue.moveToTheFront(currentNode);
        }

        if(size == capacity){
            String rearKey = intenalQueue.getRearKey();
            intenalQueue.removeNodefromRear();
            map.remove(rearKey);
            size--;
        }

        Node node = new Node(key, value);
        intenalQueue.addNodetoFront(node);
        map.put(key, node);
        size++;


    }

    class Node{
        String key;
        T value;
        Node prev, next;

        Node(final String key, T value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private class DoublyLinkedList {
        Node front, rear;

        DoublyLinkedList(){
            this.front = null;
            this.rear = null;
        }

        public void addNodetoFront(final Node node){
            if(rear == null){
                front = rear = node;
                return;
            }
            System.out.println("Adding node with key " + node.key + " to the front.");
            node.next = front;
            front.prev = node;
            front = node;
        }

        public void moveToTheFront(final Node node){
            if(front == null){
                return;
            }
            System.out.println("Moving " + node.key + " to the front with value " + node.value);
            if(node == rear){
                System.out.println("Node is at the Rear.");
                rear = rear.prev;
                rear.next = null;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = front;
            front.prev = node;
            front = node;

        }

        public void removeNodefromRear(){
            if(rear == null){
                return;
            }
            System.out.println("Removing Node from Rear with key: " + rear.key);
            if(front == rear) {
                front = rear = null;
            }else{
                rear = rear.prev;
                rear.next = null;
            }
        }

        public String getRearKey(){
            return rear.key;
        }
    }
}
