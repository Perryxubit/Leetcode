/*
    本题要求在数组中找出最小的缺失的正数，由于限制时间为O(N)，空间为O(1)，所以难度为hard...
    想了半天没有好的方法，看了一下别人的方法，思路仍然是非常巧妙...
    
    即让数组尽量满足nums[i]=i+1的排列，这样排好后找出第一个不满足nums[i]=i+1时对应的i就是我们要找的位置。
    所有排列都要在一趟遍历中完成，所以比较麻烦，具体方法是：
        从0开始对数组nums遍历，如果nums[i]大于数组长度或者小于0或者已经满足nums[i]=i+1，则跳过；否则把nums[i]和nums[nums[i]-1]交换位置。
        还要注意交换后，如果当前位置i还不满足条件并且其满足继续交换的条件(即nums[i]大于0并小于nums长度)，
        则保持下标i不变，继续对当前位进行交换，这里经常被忽视，容易错。
        最后排列好之后，直接0开始遍历找出不满足nums[i]=i+1的位置index，返回index+1就好。    

*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
		if(nums.length == 0) return 1;
		//let nums[i] = i+1;  e.g.nums[0]=1, nums[1]=2, nums[n]=n+1;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > nums.length || nums[i] <= 0 || nums[nums[i]-1] == nums[i]) continue;
			//exchange the number
			int temp = nums[nums[i]-1];
			nums[nums[i]-1] = nums[i];
			nums[i] = temp;
			if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) i--;
		}
		//traverse to find if some index is not matching the rule, then it is the result.
		for(int i=0; i<nums.length; i++)
			if(nums[i] != i+1)
				return i+1;
		return nums[nums.length-1]+1;
    }
}
