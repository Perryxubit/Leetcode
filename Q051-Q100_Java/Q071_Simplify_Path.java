/*
  很有趣的题，模拟unix文件系统的目录识别。
  比如/a/b/./c/..应该识别为/a/b， /a/../b/../c应该识别为/c。
  既然如此，我们做这个题关键的地方就是处理好回退符'..'，典型的栈问题(Stack)。
  我们定义一个栈stack, 把输入路径按照'/'来分割存到数组里，对于数组的每一个元素，
  如果是'.', 则不做任何操作，该符号表示就是unix系统的当前路径;
  如果是'..', 则表示回退，将stack顶元素弹出即可;
  如果是其他字符串，则表示是文件夹的名字，直接压入栈即可。
  
  注意: 本题最难的是'...'这个的问题，这个符号并不是回退2次(第一次我也理解错了！)， 而是一个合理的文件夹名字！！！
  你在linux里建立mkdir /usr/...，就会发现系统建立了一个叫...的文件夹！所以这种情况和其他文件夹名一起处理即可。

*/

public class Solution {
    	public String simplifyPath(String path) {
		String[] dir = path.split("/");
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<dir.length; i++) {
			if(dir[i].length() == 0) continue;
			else if(dir[i].equals(".")) {
				// don't do anything when there is a '.'
			}
			else if(dir[i].equals("..")) {
				if(!stack.isEmpty()) stack.pop(); // pop the top of stack
			}
			else { //other folder and '...', 
				//Please notice: '...' is an available folder name, not a back string!!! 
				stack.push(dir[i]);
			}
		}
		String res = "";
		ArrayList<String> list = new ArrayList<String>(stack);
		for(int i=0; i<list.size(); i++) res += "/" + list.get(i);
		if(res.length() == 0) res = "/";
		return res;
	}
}
