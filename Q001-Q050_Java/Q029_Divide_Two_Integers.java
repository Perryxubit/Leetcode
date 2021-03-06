/*
    挺难一个题，测试用例也很恶心。
    题目要求不能用* / %这三个符号实现2个数的相除。以下假设被除数为a，除数为b。
    起初我用N个b加的方法找最接近a的N，但是TLE了......
    
    实在找不到好方法，上网搜了搜解题思路，可以用位运算来做，想了一下确实比较巧妙。
    左移一位: m<<1的作用是m自乘以2，右移一位: m>>1的作用是m自除以2，于是我们把N个b相加找最接近a的值的方法转化为: 把b左移N位找最接近a的方法。
    比如:39/5， 39 = 5*4 + 5*2 + 5*1 + 4，我们可以分解为多项式 39 = 5*(2^2 + 2^1 + 2^0) + 4, 得到商4+2+1=7，余数便为4。
    以此类推，把a分解为 a = b*2^m + b*2^(m-1) + b*2^(m-2) + b*2^(m-3) + ... b*2^1 + b*2^0 + mod 的分解，用这个方法可以有效得到商和余数。
    
    当然还要注意，输入有各种恶心的越界的数...我是统一变成正数后，在返回结果时单独处理的...
    
*/

public class Solution {
    public int divide(int dividend, int divisor) {
    	long a = dividend, b = divisor;
    	boolean neg = false; // positive number
        if((a>0 && b<0)||(a<0 && b>0)) neg = true; //negative number 
        a = Math.abs(a);
        b = Math.abs(b);
        // 38/5 = 5*2^2 + 5*2^1 + 5*2^0 + 3
        
        long res = 0;
        if(a == 0) return 0;
        else if(b == 0) return Integer.MAX_VALUE;
        else if(a == b) res = 1;
        else if(b == Math.abs(1)) res = a;
        else {
        	while(a > b) {
            	// "<< 1" means to multiply 2, ">> 1" means to divide 2
            	int t = 0;
                while( (b<<t) <= a ) {
                	t++;
                }
                t = t-1;
                res += Math.pow(2, t);
                a -= (b<<t);
            }
        }
        
        if(neg == false) { //positive number
        	if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        	else return (int)res;
        }
        else { //negative number
        	if(-1 * res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        	else  return (int)(-1 * res);
        }
    }
}
