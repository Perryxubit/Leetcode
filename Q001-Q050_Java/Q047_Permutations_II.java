/*
    与上一道题(Q046)的区别是本题给的数组有重复，在这种情况下我们结果不能有重复..
    第一种方法就是用hashset过滤一下结果..当然，这可以当作一种可用的方法。
    第二种方法是通过控制深度优先搜索的顺序来达到去重的目的，感觉算思路比较难想的一道题..：
        首先，我们把给出的nums进行排序，这样重复的元素就会排列到一起，比如：{1, 1, 1, 2};
        然后在递归中, 不同于Q046, 我们让重复元素只能按照一种顺序加入group结果集中，顺序是：
        当该元素和上一个元素重复时, 上一个元素如果用过，则再将其加入结果集中。
        这样可以有效剪枝, 把重复的顺序只加入一次。

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> group = new ArrayList<Integer>();
		boolean[] flag = new boolean[nums.length];
		recursion2(nums, 0, group, result, flag);
        return result;
    }
	
	public void recursion2(int[] nums, int index, ArrayList<Integer> group, ArrayList<List<Integer>> res, boolean[] flag) {
		if(index == nums.length) {
			ArrayList<Integer> newgroup = new ArrayList<Integer>(group);
			res.add(newgroup);
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(flag[i] == true) continue;
			else if(i-1>=0 && nums[i] == nums[i-1] && flag[i-1] == false) continue;
			else {
				flag[i] = true;           
				group.add(nums[i]);
				recursion2(nums, index+1, group, res, flag);
				flag[i] = false;
				group.remove(group.size()-1);
			}
		}
		return ;
	}
}
