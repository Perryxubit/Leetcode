/*
	Jump game, 给定数组{2, 3, 1, 1, 4}, 每一个元素是当前位置可以跳跃的最远距离。
	第一种方法我用的深度优先搜索...递归的方式尝试找到最远的距离，见下文canJump函数，
	但是跪在一个巨长的用例上{1,1,1,1,1,1,1,.......1}, 递归层数太多stack overflow了..
	其实这个问题好像是贪心算法的经典问题? 我们定义最远距离变量arrive, 遍历数组中的每个元素，arrive取nums[i]+i和arive的较大值，
	这样可以逐步选出最远可以跳到的距离，最后我们对比最远的距离变量arrive和nums中的最后一个元素的index就可以得出结果。
	见canJump2函数。

*/

public class Solution {
	public boolean canJump2(int[] nums) {
		//Greedy
		int arrive = 0;
		for(int i=0; i<nums.length; i++) {
			if(i > arrive) break;
			if(nums[i]+i > arrive) arrive = nums[i]+i;
		}
		if(arrive >= nums.length-1) return true;
		return false;
    }
	
	public boolean canJump(int[] nums) {
		//DFS, recursion
		int current = 0;
        return recursion(nums, current);
    }
	public boolean recursion(int[] nums, int current) {
		if(current >= nums.length) return true;
		else {
			for(int i=nums[current]; i>=1; i--) {
				if(recursion(nums, current+i) == true) return true;
				else return false;
			}
		}
		return false;
	}
}
