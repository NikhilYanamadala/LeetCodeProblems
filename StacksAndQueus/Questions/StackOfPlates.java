package StacksAndQueus.Questions;

import java.util.*;
import java.util.stream.Stream;

public class StackOfPlates {
     /*class FixedStack<T> {
        private T[] stack;
        private int size;
        private int top;

      FixedStack<T>(int size1)

        {
            this.stack = (T[]) new Object[size];
            this.top = -1;
            this.size = size1;
        }

        public void push(T obj) {
            if (top >= size)
                throw new IndexOutOfBoundsException("Stack size = " + size);
            stack[++top] = obj;
        }

        public T pop() {
            if (top < 0) throw new IndexOutOfBoundsException();
            T obj = stack[top--];
            stack[top + 1] = null;
            return obj;
        }

        public int size() {
            return size;
        }

        public int elements() {
            return top + 1;
        }
    }*/

    public static ArrayList<Stack<Integer>> setOfStacks;

    public StackOfPlates() {
        setOfStacks = new ArrayList<>();
    }


    public void push(int value) {
        Stack<Integer> stack = getLastStack();
        if (stack != null && stack.size() != stack.capacity()) {
            stack.push(value);
        } else {
            Stack<Integer> stack1 = new Stack<>();
            stack1.push(value);
            setOfStacks.add(stack1);
        }


    }

    public Stack<Integer> getLastStack() {
        if (setOfStacks.size() == 0) {
            return null;
        }
        return setOfStacks.get(setOfStacks.size() - 1);
    }

    public int pop() {
        Stack<Integer> stack = getLastStack();
        if (stack == null) {
            throw new EmptyStackException();
        }
        int value = stack.pop();
        if (stack.isEmpty()) {
            setOfStacks.remove(setOfStacks.size() - 1);
        }
        return value;
    }


    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates();
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);
        stackOfPlates.push(4);
        stackOfPlates.push(5);
        stackOfPlates.push(6);
        for (Stack<Integer> stack : setOfStacks) {
            System.out.println(stack);
        }


    }
}
