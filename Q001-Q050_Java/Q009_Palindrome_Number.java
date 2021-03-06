/*
     判断是否为回文数，注意本题输入为int整形，不是String型。
     比较容易的做法是引用Q7.Reverse Integer的方法， 求该数x的倒序数y，如果x和y相等，则表示是回文数。

*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        else if(x/10 == 0) { //only one number
            return true;
        }
        else { // get reversed integer, if equal then return ture, else return false
            int m = 0, a = x;
            while(a != 0) {
                m = m * 10 + a%10;
                a /= 10;
            }
            if(m == x) return true;
            else return false;
        }
    }
}
