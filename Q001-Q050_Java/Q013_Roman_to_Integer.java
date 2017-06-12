/*
    这次是罗马数字转整数
	根据罗马数字规则，我们只需要诸位替换即可，
	注意如果遇到s[i+1] > s[i]的情况则表示当前i位置的数字是左减状态，需要减s[i]，其余时候为加s[i]
    
*/

public class Solution {
    public int romanToInt(String s) {
		if(s.length() == 0) return 0;
		int num=0, nextnum=0;
		for(int i=0; i<s.length(); i++) {
			int curNum = romanNum(s.charAt(i));
			if(i+1 < s.length()) nextnum = romanNum(s.charAt(i+1));
			if(nextnum > curNum) //next > cur, using -
				num -= curNum;
			else if(nextnum <= curNum) // next <= cur, using +
				num += curNum;
		} 
		return num;
    }
	
	private int romanNum(char ch) {
		switch (ch) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}
}
