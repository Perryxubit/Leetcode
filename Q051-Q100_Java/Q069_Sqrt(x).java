/*
    本题要求模拟数学计算中的算术平方根。
    结果向下取整即可 (比如Sqrt(3) = 1)。
    O(N)方法超时了..不用试了，只能用O(logN)方法...那只能用二分查找了。
    从1到x的中间值开始找，最终得到平方根。
    要注意的是 中间计算mid * mid的时候会溢出... 看了solution的代码是比较mid和x/mid的话就不会溢出...所以就这么写了..

*/

public class Solution {
    public int mySqrt(int x) {
		if(x == 1 || x == 0) return x;
		int left = 1, right = x, res = 0;
		while(left <= right) {
			int mid = (left+right)/2;
			if(mid > x/mid) {
				right = mid-1;
			}
			else if(mid < x/mid) {
				left = mid+1;
				res = mid;
			}
			else { // t == x
				res = mid;
				break;
			}
		}
		return res;
	}
}
