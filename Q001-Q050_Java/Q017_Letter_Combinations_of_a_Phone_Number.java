/*
    ### 题解 ###
    本题目意思为模拟9键输入法，求对应输入字符串的9键输入法的所以可能字母输出，
    9键输入法一次为 2-"abc", 3-"def", 4-"ghi", 5-"jkl", 6-"mno", 7-"pqrs", 8-"tuv", 9-"wxyz"
    假如输入97，则函数需要返回集合{zs zr zq zp ys yr yq yp xs xr xq xp ws wr wq wp }
  
    ### 思路 ### 
    依次遍历输入的数字，使用队列的方式存储。
    例如输入362，则先将3对应的abc放入队列Q中，得到
    Q: d e f
    然后将Q中元素依次取出，将6对应的字母依次组合后放入Q中，得到
    Q: fo fn fm eo en em do dn dm
    最后将Q中元素依次取出，将2对应的字母依次组合后放入Q中，得到
    Q: foc fob foa fnc fnb fna fmc fmb fma eoc eob eoa enc enb ena emc emb ema doc dob doa dnc dnb dna dmc dmb dma
    以此类推，使用队列数据结构可以整齐的将字母按照字典序依次组合，并且在占用空间复杂度最小的情况下存储所有组合。

*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> array = new ArrayList<>();
        if(digits.length() == 0) return array; //empty
        String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i=0; i<digits.length(); i++)
        	if(!Character.isDigit(digits.charAt(i)) || digits.charAt(i) == '0' || digits.charAt(i) == '1')
        		return array;
        
        //statement of Q: queue
        Queue<String> queue = new LinkedList<>();
        int firstNum = Integer.parseInt(digits.charAt(0)+"");
        //initialize Q: store first 3-4 numbers in queue
        for(int i=0; i<key[firstNum].length(); i++) 
        	queue.offer(key[firstNum].charAt(i) + "");
        
        for(int i=1; i<digits.length(); i++) {
        	int index = Integer.parseInt(digits.charAt(i) + "");
        	while(queue.element().length() == i) { // get all numbers whose length is i
        		String oldstr = queue.poll();
        		// for number 1 2 3 4 5 6 8
        		queue.offer(oldstr + key[index].charAt(0));
        		queue.offer(oldstr + key[index].charAt(1));
        		queue.offer(oldstr + key[index].charAt(2));
        		if(key[index].length() == 4) { 
        			// for number 7 9
        			queue.offer(oldstr + key[index].charAt(3));
        		}
        	}
        }
        while(queue.size() > 0) { //put entries from queue to array
        	array.add(queue.poll());
        }
        return array;
    }
}
