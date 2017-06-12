/*
	整数转罗马数字，规则为：
	I=1，V=5，X=10，L=50，C=100，D=500，M=1000;
	相同的罗马数字最多不能超过三个;
	左减右加。(即IV为4，VI为6)
    参考网上的思路，我用的比较笨的方法..如代码所示。
    
*/

public class Solution {
    public String intToRoman(int num) {
        // 1 - 3999
		String[] ge_str = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};   // 1-10
		String[] shi_str = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};   // 10 - 100
		String[] bai_str = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};  // 100 - 1000
		String[] qian_str = {"", "M", "MM", "MMM"}; // 1000 - 3000
		int qian = num/1000;     // 3XXX
		int bai  = num%1000/100; // X2XX 
		int shi  = num%100/10;   // XX5X
		int ge   = num%10;       // XXX4
		
		String str = qian_str[qian] + bai_str[bai] + shi_str[shi] + ge_str[ge];
		return str;
    }
}
