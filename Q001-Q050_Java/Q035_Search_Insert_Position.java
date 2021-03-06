/*
    最简单的二分查找问题... 如果找不到要给出目标元素的插入位置，其实就是遍历到最后的位置...
    实现详见代码，没啥好说的。

*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
    	int pos = -1;
    	int left = 0, right = nums.length-1;
    	while(left <= right) {
    		int mid_index = (left+right)/2;
    		if(nums[mid_index] == target) return mid_index;
    		else if(target < nums[mid_index]) {
    			right = mid_index-1;
    		}
    		else { //target > nums[mid_index]
    			left = mid_index+1;
    		}
    	}
        return left;
    }
}
