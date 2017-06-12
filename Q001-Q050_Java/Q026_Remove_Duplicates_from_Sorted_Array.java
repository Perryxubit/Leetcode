/*
    非常简单的题，对排序的数组去重复，并把不重复的数移动到前N个位置。
    具体实现见代码。

*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int j=1;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] == nums[i-1]) { //pass
				continue;
			}
			else {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
    }
}
