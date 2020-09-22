package StacksAndQueus.Questions;

import java.util.Stack;

public class SortStack {
    public Stack<Integer> stack, sortedStack;

    public SortStack() {
        stack = new Stack<>();
        sortedStack = new Stack<>();
    }

    public Stack<Integer> createStack(int[] array) {
        for (int i : array) {
            stack.push(i);
        }
        return stack;
    }
// Runtime = O(N^2) space = O(N)
    public Stack<Integer> sortStack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            if (sortedStack.isEmpty() && !stack.isEmpty()) {
                sortedStack.push(stack.pop());
            }
            int value = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > value) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(value);
        }
        while (!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());

        }        return stack;

    }

    public static void main(String[] args) {
        int[] array = {5, 1, 3, 7, 2};
        SortStack sortStack = new SortStack();
        System.out.println(sortStack.sortStack(sortStack.createStack(array)));

    }
}
