/*
	本题要在给定数组nums里找和为target的组合，注意本题数组nums不含重复元素，结果也不能包含重复组合。
	由于不知道结果组合里包含几个数字，所以可以用回溯法来解(深度优先搜索)。
    
	代码非常简单，深度优先得把每个数加到一起，如果是target就输出，如果大于target就返回，如果小于target就继续深度搜索。
	要注意递归时要对数组nums遍历时不能一直从0到nums.length，而是从上一层的nums的索引处开始遍历，否则没有剪枝，会出现重复情况。
	本程序用index这个遍历来递归时防止这种情况。
	
    这里要提醒java的递归，找到结果时必须new一个新的list<integer>加入到结果集中，而不是把当前的加入...
    否则已经加入的集合会在其他层调用时被改动...
	
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> group = new ArrayList<Integer>();
        recursion(candidates, 0, target, group, list);
    	return list;
    }
    
    public void recursion(int[] nums, int index, int target, List<Integer> group, List<List<Integer>> list) {
    	if(target == 0) { // correct answer group
    		List<Integer> tempgroup = new ArrayList<Integer>(group);
    		list.add(tempgroup);
    		return ;
    	}
    	else if(target < 0) { // wrong answer, just return
    		return ; 
    	}
    	else {
	    	for(int i=index; i<nums.length; i++) {
	    		group.add(nums[i]); // add new number to check
	    		recursion(nums, i, target-nums[i], group, list); // index is used to control the repeat entries
	    		//if we don't set index, there will be duplicated results, like 2 2 3 and 2 3 2 and 3 2 2, 
	    		//we must set index to let loop starts from the current index (not went to previous index)
	    		group.remove(group.size()-1); // remove the last one (backtrace)
	    	}
    	}
    }
}
