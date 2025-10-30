package collectionFramework;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> books = new Stack<>();

        books.push("Java Programming");
        books.push("Data Structures");
        books.push("Algorithms");

        System.out.println("Stack of Books " + books);
    }
}
