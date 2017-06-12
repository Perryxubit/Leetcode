/*
    虽然是Easy的题，但貌似是一道动态规划的标准问题...
    对数组进行遍历，每一位的sum值得动态转移方程为：sum[i] = Max(sum[i-1]+nums[i], nums[i])
    也就是说 如果sum加上当前位的值还不如当前位大 (其实也就是说sum为负..)， 则把当前位的值作为新的子串的首位。
    在这个遍历过程中找到最大的sum并在结尾返回即可。

*/

public class Solution {
    public int maxSubArray(int[] nums) {
		//DP: sum[i] = Max(sum[i-1]+nums[i], nums[i])
		int sum = nums[0], max = sum;
		for(int i=1; i<nums.length; i++) {
			if(sum+nums[i] > nums[i]) sum = sum+nums[i];
			else sum = nums[i];
			if(sum > max) // get bigger max number
				max = sum;
		}
		return max;
	}
}
