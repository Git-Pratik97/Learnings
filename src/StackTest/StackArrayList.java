package StackTest;

import java.util.ArrayList;
import java.util.Stack;

public class StackArrayList {

//    static class Stack{
//        static ArrayList<Integer> list = new ArrayList<>();
//
//        public static boolean isEmpty(){
//            return list.size() == 0;
//        }
//
//        public static void push(int data){
//            list.add(data);
//        }
//
//        public static int pop(){
//            if(isEmpty()){
//                return -1;
//            }
//            int top = list.get(list.size() - 1);
//            list.remove(list.size() - 1);
//
//            return top;
//        }
//
//        public static int peek(){
//            if(isEmpty()){
//                return -1;
//            }
//            return list.get(list.size() - 1);
//        }
//    }

    public static void pushAtBottom(Stack<Integer> stack,int data){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        pushAtBottom(stack,5);

//        while(!stack.isEmpty()){
//            System.out.print(stack.peek() + "->");
//            stack.pop();
//        }

        reverseStack(stack);

        while(!stack.isEmpty()){
            System.out.print(stack.peek() + "->");
            stack.pop();
        }

//        System.out.println("Top Element of Stack : " + stack.peek());
//        System.out.println(stack.pop());
//        System.out.println("Top Element of Stack : " + stack.peek());
//        stack.pop();


    }
}
