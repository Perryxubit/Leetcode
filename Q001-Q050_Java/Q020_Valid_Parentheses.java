/*
    括号匹配判断，非常简单而又典型的栈数据结构练习用的算法题... 话说老师们都喜欢这个题。
    O(N)方法：
    把括号依次push入栈，如果push的括号和栈顶括号匹配，即字符串中的右括号和栈顶的左括号匹配，则栈顶pop出来。
    把字符串便利一边之后，如果栈非空，则表示中间有括号不匹配；如果是空，则表示每个括号都已经得到匹配，返回true :)
   
*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(stack.size() == 0) {
				stack.push(ch);
				continue;
			}
			char cmp = stack.pop();
			if(!( (cmp=='('&&ch ==')')||(cmp=='['&&ch==']')||(cmp=='{'&&ch=='}') )) {
				//not match, push both again
				stack.push(cmp);
				stack.push(ch);
			}
		}
		if(stack.size() > 0) return false;
		else return true;
    }
}
