/*
    题意很难读懂，解释一下就是：
    对数字1，这是1个1，所以是11；
    对数字11，这是2个1，所以是21；
    对数字21，这是1个2，1个1，所以是1211
    对数字1211，这是1个1，1个2，2个1，所以是111221
    ....
    
    我的做法很普通，就是依次遍历数字，记录数字preNum，如果当前数字是新数字(curNum != preNum)，就把preNum的个数连同preNum存入结果..
    由于要求第n个结果，按照这个规律循环n次即可。

*/

public class Solution {
    public String countAndSay(int n) {
        String rev = "1", temp = "";
        int preNum = -1, curNum = -1, count = -1;
        for(int i=1; i<n; i++) {
        	temp = "";
        	for(int k=0; k<rev.length(); k++) {
        		curNum = Integer.parseInt(rev.charAt(k)+"");
        		if(k == 0) {
        			preNum = curNum;
        			count = 1;
        			continue;
        		}
        		curNum = Integer.parseInt(rev.charAt(k)+"");
        		if(curNum != preNum) { // new number
        			temp += count + "" + preNum;
        			preNum = curNum;
        			count = 1;
        		} 
        		else { // old number
        			count++;
        		}    		
        	}
        	temp += count + "" + preNum;
        	rev = temp;
        }
        return rev;
    }
}
