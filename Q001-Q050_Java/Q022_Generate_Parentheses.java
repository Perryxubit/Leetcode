/*
    输出N个括号的组合方式，仔细想想其实是个二叉树的遍历问题..
    用递归可以遍历所有可能方式，用left和right分别记录左括号和右括号的数量

    如果左括号和右括号数量都为N，则存入list，作为一条结果。
    否则用深度优先(这个问题中又可以叫左括号优先)的方式先添加左括号'(', 然后添加右括号')'。
    需要注意这里的控制右括号在左括号右边的技巧是:
    如果左括号数量比右括号数量多时，才添加右括号，否则不能添加右括号(右括号比左括号多就会发生括号不匹配问题)

*/

public class Solution {
  public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        char[] array = new char[2*n];
        recursion(list, array, 0, 0, n, 0);
        return list;
    }
    private void recursion(List<String> list, char[] array, int left, int right, int N, int j) {
    	if(left == N && right == N) { // match, record group
    		String str = new String(array);
//    		System.out.println(s);
    		list.add(str);
    		return;
    	}
    	else { // not match, continue to recursion
	    	if(left < N) { // add (
	    		array[j] = '(';
	    		recursion(list, array, left+1, right, N, j+1);
	    	}
	    	if(right < N && left > right) { // add ')' if '(' is more then ')'
	    		array[j] = ')';
	    		recursion(list, array, left, right+1, N, j+1);
	    	}
    	}
    }
}
