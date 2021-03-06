/*
    很简单的题，输入可能是正数或者负数，把数每一位取出来再乘10即可逆转
	唯一要注意的是过程中会overflow，需要用long来存，并且如果超过了int最大值或最小值(负数)，则要返回0，这里我之前没考虑错了很多次。
  
*/

public class Solution {
    public int reverse(int x) {
       long b=0, a=x; //if not long, will caused overflow...
        //1234 -> 4321
        //-> 40+3 -> 43 *10 +2
        while(a != 0) {
            b = b*10 + a%10;
            a = a/10;
        }
        if (b>=Integer.MAX_VALUE || b<=Integer.MIN_VALUE) return 0; //overflow check.
        else return (int)b;
    }
}
