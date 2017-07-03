/*
    非常简单的一道题，给出一个字符串，求字符串最后一个单词的长度。
    依次计算每个单词长度，遇到空格则把长度清零即可，这样可以得到最后一个单词的长度。
    唯一要注意字符串结尾的空格可以先去掉。

*/

public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        String str = s.trim();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ' ') {
				len = 0;
			}
			else len++;
		}
		
		return len;
    }
}
