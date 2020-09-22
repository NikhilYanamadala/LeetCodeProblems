package RecursionAndDynamicProgramming;

public class RecursiveMultiply {
    public int minprodct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        int[] memo = new int[smaller+1];
        return minProducthelper2(smaller, bigger);
//        return minProducthelperMemo(smaller, bigger,memo);

    }
// approach 1 REcursion
    public int minProducthelper(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }
        int s = smaller >> 1;
        int side1 = minProducthelper(s, bigger);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProducthelper(smaller - s, bigger);

        }
        return side1+side2;
    }
//    approach3
    public int minProducthelper2(int smaller, int bigger) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }
        int s = smaller >> 1;
        int halfProduct = minProducthelper2(s, bigger);
        if (smaller % 2 == 0) {
            return halfProduct+halfProduct;
        }else {
            return halfProduct+halfProduct+bigger;
        }
    }
//    Approach2 memosation
    public int minProducthelperMemo(int smaller, int bigger,int[] memo) {
        if (smaller == 0) {
            return 0;
        } else if (smaller == 1) {
            return bigger;
        }else if(memo[smaller] > 1){
            return memo[smaller];
        }
        int s = smaller >> 1;
        int side1 = minProducthelperMemo(s, bigger,memo);
        int side2 = side1;
        if (smaller % 2 == 1) {
            side2 = minProducthelperMemo(smaller - s, bigger,memo);

        }
        memo[smaller] = side1+side2;
        return memo[smaller];
    }


    public static void main(String[] args) {
    RecursiveMultiply recursiveMultiply = new RecursiveMultiply();
        System.out.println(recursiveMultiply.minprodct(80,30));
    }
}
