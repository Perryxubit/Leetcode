/*
    实现strStr()方法，即找第一次出现的目标子串的位置。
    为了练习，我没用任何String的api :)
    O(M*N) 方法: 
    实现如代码所示... 应该没有更快的方法了吧...
    
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int pos = -1;
		for(int i=0; i<haystack.length(); i++) {
			int k=0, j=0;
			//if the rest part length of haystack is smaller than needle, then quit
			if(haystack.length()-i < needle.length()) break; 			
			for(j=0; j<needle.length(); j++) {
				if(haystack.charAt(i+j) != needle.charAt(k+j)) {
					break;
				}
			}
			if(j == needle.length()) { // if traverse of needle is finsish, then it is the substr of haystack
				pos = i;
				break;
			}
		}
		return pos;
    }
}
