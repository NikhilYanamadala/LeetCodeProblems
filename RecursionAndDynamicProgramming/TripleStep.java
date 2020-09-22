package RecursionAndDynamicProgramming;
// you will be overflown at n=36 issue can be solved using BigInteger
public class TripleStep {
// approach1 RT=O(3^N)
    public int hop(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else {
            return hop(n - 1) + hop(n - 2) + hop(n - 3);
        }

    }
// Approach2
    public int countWays(int n){
        int[] memo = new int[n+1];
        for (int i = 0; i < memo.length; i++) {
            memo[i]=-1;
        }
        return countWays(n,memo);
    }
    public int countWays(int n , int[] memo){
        if(n <0){
            return 0;
        }else if(n==0){
            return 1;
        }else if(memo[n] > -1){
            return memo[n];
        }else {
            memo[n] = countWays(n-1,memo)+countWays(n-2,memo)+countWays(n-3,memo);
            return memo[n];
        }
    }
    public static void main(String[] args) {
        TripleStep tripleStep = new TripleStep();
//        System.out.println(tripleStep.hop(4));
        System.out.println(tripleStep.countWays(36));
    }
}
