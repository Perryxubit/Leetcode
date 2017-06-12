/*
    一道简单的题，把数组中指定元素删除。
    O(N)方法：
    把数组中所有不等于val的元素依次左移即可。

*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}	
		}
		return j;
    }
}
