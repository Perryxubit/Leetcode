/*
	  本题求字符串的最大不重复子串。
	  O(N)方法：用了一个比较巧妙的方法，也是受同事启发给出的解法：
	  使用hash表记录每个字符的出现位置，并设置变量str_start表示子串的开始位置。
	  当遍历到某个字符C在hash表中已经存在，并且其对应的hash值pos(该字符位置)大于str_start，
	  则表示str_start之后有重复字符串出现，需要将新的str_start设置为pos+1，然后开始新子串的遍历；
	  (如果pos<str_start，则表示C在str_start之前出现过，对当前子串无影响，可以在hash表中更新该字符C对应的新的hash值)
	  在逐步扩展的过程中，每将一个字符更新到hash表中时，都要记录当前的子串长度，逐步找出最大值MAX即可。

*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int Str_start = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(map.get(c) == null) { //new char without repeating  
				map.put(c, i);
				max = max>(i+1-Str_start)?max:(i+1-Str_start);
			}
			else {
				int pos = map.get(c);
				if(pos >= Str_start) { // repeat char
					Str_start = pos+1;
					map.put(c, i);
				}
				else { // non-repeat char
					map.put(c, i);
					max = max>(i+1-Str_start)?max:(i+1-Str_start);
				}
			}
		}
		
		return max;
    }
}
