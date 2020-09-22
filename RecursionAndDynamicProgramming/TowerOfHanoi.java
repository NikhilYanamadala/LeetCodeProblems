package RecursionAndDynamicProgramming;

import java.util.Stack;

public class TowerOfHanoi {
    Stack<Integer> stack = null;
    int index;

    public TowerOfHanoi(int i) {
        stack = new Stack<>();
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void add(int d) {
        if (!stack.isEmpty() && stack.peek() <= d) {
            System.out.println("Error placing disk=" + d);
        } else {
            stack.add(d);
        }

    }
    public void moveDiscks(int n,TowerOfHanoi destination,TowerOfHanoi buffer){
        if(n > 0){
            moveDiscks(n-1,buffer,destination);
            moveTopTo(destination);
            buffer.moveDiscks(n-1,destination,this);
        }
    }
    public void moveTopTo(TowerOfHanoi destination){
        int top = stack.pop();
        destination.add(top);
    }
    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi[] towerOfHanois = new TowerOfHanoi[n];
        for (int i = 0; i < 3; i++) {
            towerOfHanois[i] = new TowerOfHanoi(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towerOfHanois[0].add(i);
        }
        System.out.println(towerOfHanois[0].stack);
        towerOfHanois[0].moveDiscks(n,towerOfHanois[2],towerOfHanois[1]);
        System.out.println(towerOfHanois[2].stack);

    }
}
