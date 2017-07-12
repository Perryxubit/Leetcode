/*
    本问题是高精度加法的一个简化版, 对给定的整数加1，相当于模拟自加运算。
    具体的实现直接看代码吧.. 算是最基本的问题。

*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, i = digits.length-1;
        do {
        	digits[i] = (digits[i] + carry);
        	carry = digits[i]/10;
        	digits[i] = digits[i]%10;
        	i--;
        } while(i >= 0 && carry != 0);
       
        int[] res;
        //have carry in first number
        if(carry != 0) {
        	res = new int[digits.length+1];
        	for(int k=0; k<digits.length; k++) res[k+1] = digits[k];
        	res[0] = carry;
        }
        else {
        	res = new int[digits.length];
        	for(int k=0; k<digits.length; k++) res[k] = digits[k];
        }
        
        return res;
    }
}
