/*
    有意思的题，要求在rotated array里查找target，(当然直接暴力搜索也可以过..)
    rotated array就是形如 {7 8 9 1 2 3 4 5 6} 的有序数组经过一次旋转后得到的结果。研究了一些相关的想法，并做了很多测试后，思路总结如下：
    1) 大概思路是，对于这样的数组A来说，中间元素mid的左侧或者右侧肯定有一侧是升序排列的，我们要先找出哪侧是有序的：
        如果该侧最左边元素比最右边元素小，那么该侧就是有序的。
    2) 之后我们可以用目标元素和中间元素比较，比如在刚才数组A中查找目标-4，由于4大于中间元素2，并且右边是有序的，则直接在右侧二分查找即可。
        如果在数组A中查找目标为8，发现8是大于中间元素2的，那么先看有序的右侧，发现右侧最大是6，小于我们要找的8，
        于是我们就在左侧按照思路从1)开始继续按照相同套路找即可。
        如果在数组A中查找目标为1，发现1是小于中间元素2的，那么我们直接在就在左侧按照我们的思路从1)开始继续按照相同套路找即可。
      
*/

public class Solution {
    public int search(int[] nums, int target) {
        //4 5 6 7 (8) 9 1 2 3
    	int left = 0, right = nums.length-1;
    	while(left <= right) {
    		int mid_index = (left+right)/2;
    		if(target == nums[mid_index]) return mid_index;
    		else {
    			//judge which side is ordered
    			if(left <= mid_index-1 && nums[left] <= nums[mid_index-1]) { 
    				// left part is ordered
    				if(nums[left] <= target && target <= nums[mid_index-1]) { // target is in left part
    					if(target <= nums[mid_index-1]) {
        					right = mid_index-1;
        				}
        				else left = mid_index+1;
    				}
    				else { //target is not in left part
    					left = mid_index+1;
    				}	
    			}
    			else if(mid_index+1 <= right && nums[mid_index+1] <= nums[right]) { // right part is ordered
    				// right part is ordered
    				if(nums[mid_index+1] <= target && target <= nums[right]) { // target is in right part
    					if(target >= nums[mid_index+1]) {
        					left = mid_index+1;
        				}
        				else right = mid_index-1;
    				}
    				else { //target is not in right part
    					right = mid_index-1;
    				}		
    			}
    		}
    		if(left == right && nums[left] != target) return -1;	
    	}    	
    	
        return -1;
    }
}
