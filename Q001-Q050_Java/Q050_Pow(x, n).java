/*
    本题目要求模拟pow函数，即求M的N次方。
    要注意N可能是负数...
    用O(N)方法的话会TLE...所以只能用O(logN)的方法了。
    递归得N分成两份，然后依次相乘得到结果，如recursion函数。
    
    同理,可以把N三等分，结果更快一些，如recursion2函数。
	同理..还可以4等分，5等分...N等分... 程序会越来越快，在此不做测试了。
    
*/

public class Solution {
   public double myPow(double x, int n) {
		int m = Math.abs(n);
		double rev = recursion(x, m);
		
		if(n<0) rev = 1.0/rev;
        return rev;
    }
	public double recursion(double x, int m) {
		//halve
		if(m == 0) return 1;
		else if(m == 1) return x;
		
		double r = recursion(x, m/2);
		if(m%2 == 0) { //even number
			return r*r;
		}
		else { //odd number
			return r*r*x;
		}
	}
	
	public double recursion2(double x, int m) {
		//trisect
		if(m == 0) return 1;
		else if(m == 1) return x;
		else if(m == 2) return x*x;
		
		double r = recursion2(x, m/3);
		if(m%3 == 0) {
			return r*r*r;
		}
		else if(m%3 == 1) { 
			return r*r*r*x;
		}
		else {
			return r*r*r*x*x;
		}
	}
}
