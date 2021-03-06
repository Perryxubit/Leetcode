/*
    求字符串数组的最长公共前缀，不要想错题意，只求前缀即可。
    我们可以先求出最短的字符串的长度minLen，然后遍历这个长度的字符即可，
    注意这里我是从minLen向0递减遍历的，这样通常可以更快找到最长前缀。
    
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE, min_index = -1;
    	for(int i=0; i<strs.length; i++) // get shortest one
        	if(strs[i].length() < min) {
        		min = strs[i].length();
        		min_index = i;
        	}
    	if(strs.length == 0 || min == 0) return "";
        
    	String common = "";
    	for(int j=min; j>=0; j--) {
    		common = strs[min_index].substring(0, j);
    		int k = 0;
    		while(k < strs.length) {
    			if(!strs[k].substring(0, j).equals(common)) // not equal, then get next prefix
    				break;
    			k++;
    		}
    		if(k == strs.length || j == 0) { // longest one, or no more common one
    			break;
    		}
    	}
        return common;
    }
}
