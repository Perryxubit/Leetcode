/*
    求全排列问题，给的数组没有重复数字。
    典型的深度优先搜索问题..用递归来解吧。
    用一个flag数组来标记当前深度搜索时某一位是否已经使用过，使用过则跳过当前位即可
    实现非常简单，见代码。

*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> group = new ArrayList<Integer>();
		boolean[] flag = new boolean[nums.length];
		recursion(nums, 0, group, result, flag);
		
        return result;
    }
	
	public void recursion(int[] nums, int index, ArrayList<Integer> group, ArrayList<List<Integer>> res, boolean[] flag) {
		if(index == nums.length) {
			ArrayList<Integer> newgroup = new ArrayList<Integer>(group);
//			for(int i=0; i<newgroup.size(); i++) System.out.print(newgroup.get(i));
//			System.out.println();
			res.add(newgroup);
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if(flag[i] == true) continue;
			else {
				flag[i] = true;
				group.add(nums[i]);
				recursion(nums, index+1, group, res, flag);
				flag[i] = false;
				group.remove(group.size()-1);
			}
		}
		return ;
	}
}
