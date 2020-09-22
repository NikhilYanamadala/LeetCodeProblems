package StacksAndQueus.Questions;

import java.util.Stack;

public class StackMin {
    public static Stack<NodeWithMin> stack = null;

    public StackMin() {
        stack = new Stack<>();
    }

    class NodeWithMin {
        public int value;
        public int min;

        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        stack.push(new NodeWithMin(value, newMin));

    }

    public int min() {
        if (stack.empty()) {
            return Integer.MAX_VALUE;//error value
        } else {
            return stack.peek().min;
        }
    }

    public int pop() {
        if (stack.empty()) {
            return Integer.MAX_VALUE;//error value
        } else {
            return stack.peek().value;
        }

    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();

        stackMin.push(3);
        stackMin.push(5);
        System.out.println("Min:" + stackMin.min());
        stackMin.push(1);
        System.out.println("Min:" + stackMin.min());
        stackMin.push(8);

        System.out.println(stack);


    }
}
