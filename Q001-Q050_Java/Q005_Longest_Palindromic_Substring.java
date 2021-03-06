/*
      求最长回文子串，比较有意思的题，我使用动态规划来解，虽然A了但是性能不是很好... 还没有试过用其他方法，以后有机会再深入研究。
      动态规划(DP):
      对于字符串ababc，建立二维矩阵: (bool型即可)
                a b a b c
              a T  
              b T T 
              a T T T
              b T T T T
              c T T T T T
      第一行为a(Str[0])到ababc其他位是否为回文串，
      第二行为b(Str[1])到ababc其他位是否为回文串，
      以此类推，第N行为Str[N-1]到其他位是否为回文串。
      首先，我们另矩阵对角线以及下半部都为T(字符本身是回文的，并且空字符也是回文的)。
      对于上半部的每个位置，假如该位置a[i][j]对应的2字符相等，则该位置是否为回文的特性由a[i+1][j-1]决定(即去掉两边的子串是否回文)
      根据状态转移结果，填满矩阵，得到：
                a b a b c
              a T F T F F
              b T T F T F
              a T T T F F
              b T T T T F
              c T T T T T
      我们可以矩阵中看到..最靠近右上角的T是越长的回文子串，包括aba和bab，我们可以输出第一个最长的串作为答案返回。
  
*/

public class Solution {
	public String longestPalindrome(String s) {
		//use Dynamic programming
		boolean[][] DPArray = new boolean[s.length()][s.length()];
		int max = 0;
		String maxString = "";
		if(s.length()>0) { // first char is palindrome
			max = 1;
			maxString = s.charAt(0) + "";
		}
		else return ""; //no length str
		
		//initial:
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<=i; j++) {
				DPArray[i][j] = true; // when length <= 1, is palindrome
			}
		}
		//DP:
		for(int len = 1; len<s.length(); len++) {
			for(int i=0; i+len<s.length(); i++) {
				if(s.charAt(i) == s.charAt(i+len)) {
					// if equal, then check array [i+1][j-1]
					DPArray[i][i+len] = DPArray[i+1][i+len-1];
					if(DPArray[i][i+len] == true && len+1 > max) {
						max = len+1;
						maxString = s.substring(i, i+len+1);
					}
				}
				else DPArray[i][i+len] = false;
			}
		}
		return maxString;
    }
}
