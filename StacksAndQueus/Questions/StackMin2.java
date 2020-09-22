package StacksAndQueus.Questions;

import java.util.Stack;

public class StackMin2 {
    public static Stack<Integer> stack = null;
    public static Stack<Integer> stack2 = null;
    public StackMin2() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int value) {
        if (value < min());{
            stack2.push(value);
        }
        stack.push(value);

    }

    public int min() {
        if (stack2.empty()) {
            return Integer.MAX_VALUE;//error value
        } else {
            return stack2.peek();
        }
    }

    public int pop() {
        if (stack.empty()) {
            return Integer.MAX_VALUE;//error value
        } else {
            int value = stack.pop();
            if (value==min()){
                stack2.pop();
            }
            return value;
        }

    }

    public static void main(String[] args) {
        StackMin2 stackMin = new StackMin2();

        stackMin.push(3);
        stackMin.push(5);
        System.out.println("Min:" + stackMin.min());
        stackMin.push(1);
        System.out.println("Min:" + stackMin.min());
        stackMin.push(8);

        System.out.println(stack);


    }
}
