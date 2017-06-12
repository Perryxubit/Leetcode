/*
  类似上一道题: Q039，本题给的输入数组nums可以包含重复元素，这个情况下就要好好研究去重复的问题了...
  我用的是hashset的方式来去重，把符合的结果排序后加入set中....
  当然这个算法性能一般，不知道还有什么高端方法可以控制重复结果，以后再研究。
	
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> group = new ArrayList<Integer>();
    	HashSet<String> set = new HashSet<String>();
        recursion2(candidates, 0, target, group, list, set);
    	return list;
    }
    
    public void recursion2(int[] nums, int index, int target, List<Integer> group, List<List<Integer>> list, HashSet<String> set) {
    	if(target == 0) { // correct answer group
    		List<Integer> tempgroup = new ArrayList<Integer>(group);
    		tempgroup.sort(null);
    		String setStr = "";
    		for(int i=0; i<tempgroup.size(); i++) {
    			setStr += tempgroup.get(i)+"#";
    		}
    		if(!set.contains(setStr)) { // new result
        		list.add(tempgroup);
        		set.add(setStr);
    		}
    		return ;
    	}
    	else if(target < 0) { // wrong answer, just return
    		return ; 
    	}
    	else {
	    	for(int i=index; i<nums.length; i++) {
	    		group.add(nums[i]); // add new number to check
	    		recursion2(nums, i+1, target-nums[i], group, list, set); // index is used to control the repeat entries
	    		//if we don't set index, there will be duplicated results, like 2 3 4 or 2 4 3 or 3 2 4, 
	    		//we must set index to let loop starts from the current index (not went to previous index)
	    		group.remove(group.size()-1); // remove the last one (backtrace)
	    	}
    	}
    }
}
