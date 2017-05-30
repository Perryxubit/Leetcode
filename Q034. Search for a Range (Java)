/*
    题目要求用O(logN)方法查找排好序的数组中的目标元素的起始/结束位置 (数组中有重复元素)
    既然是O(logN)，那只能继续用二分查找了，与普通的二分查找不同的是，当数组的中间元素与target相同时，要对两边各自再继续进行二分查找。
    并且在查找的时候维护最小的start和最大的end即可，我用的递归方法来做，感觉比较好处理，详见代码。
    
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] rec = new int[] {-1, -1};
        int left = 0, right = nums.length-1;
        if(nums.length==0) return rec;
        recursion(rec, nums, target, left, right);
        return rec;
    }
	
	public void recursion(int[] rec, int[] nums, int target, int left, int right) {
		int mid_index = (left+right)/2;
		if(left > right) return;
		else if(target == nums[mid_index]) {
    		if(mid_index < rec[0] || rec[0] == -1) rec[0] = mid_index; //find smaller start index
    		if(mid_index > rec[1] || rec[0] == -1) rec[1] = mid_index; //find larger end index
    		recursion(rec, nums, target, left, mid_index-1);
    		recursion(rec, nums, target, mid_index+1, right);
    	}
		else if(target < nums[mid_index]) { // traverse left part
			recursion(rec, nums, target, left, mid_index-1);
		}
		else { // traverse right part
			recursion(rec, nums, target, mid_index+1, right);
		}
		return ;
	}
}
