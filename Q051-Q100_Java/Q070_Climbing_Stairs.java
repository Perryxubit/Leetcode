/*
    一看就是斐波那契数列问题: 1 1 2 3 5 8 13...
    求高度为n的爬梯子方式的结果就是求斐波那契数列的第n+1项!

*/

public class Solution {
    public int climbStairs(int n) {
        int step1 = 1, step2 = 1;
        //Fibonacci: climbStarts(n) = Fibonacci(n+1)
        for(int i=0; i<n-1; i++) { // loop n-1 times
            int t = step1;
            step1 = step1 + step2;
            step2 = t;
        }
        return step1;
    }
}
