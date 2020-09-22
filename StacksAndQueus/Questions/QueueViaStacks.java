package StacksAndQueus.Questions;

import java.util.Stack;

public class QueueViaStacks {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public QueueViaStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void push(int value){
        stack2.push(value);
    }
    public int pop(){
        shiftStacks();
        return stack1.pop();

    }
    public void shiftStacks(){
        if(stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }
    public static void main(String[] args){
        QueueViaStacks queueViaStacks =  new QueueViaStacks();
        queueViaStacks.push(1);
        queueViaStacks.push(2);
        queueViaStacks.push(3);
        queueViaStacks.push(4);
        queueViaStacks.push(5);
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());
        System.out.println(queueViaStacks.pop());




    }}
