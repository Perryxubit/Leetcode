/*
    本题求N个数的排列的第K个序列，其实就是按照字典序排列。
    我非常无耻的调用了Q031(Next Permutation)的方法，对序列进行k-1次nextPermutation操作即可...
    虽然性能不好，但还是可以过的 :) 
    其他更快的方法以后再研究, 目前还没找到...

*/

public class Solution {
    public String getPermutation(int n, int k) {
        // initial str = "1234"
		int[] array = new int[n];
		for(int i=1; i<=n; i++) {
			array[i-1] = i;
		}
		int index = 1;
		while(index < k) {
			//get next sequence
			nextPermutation(array);
			index++;
		}
		
		String str = "";
		for(int i=1; i<=n; i++) str += array[i-1];
		return str;
    }
	
	public void nextPermutation(int[] nums) {
		// 1 2 6 5 4 -> 1 2 6 5 4, find the last number which is not meet the descending order condition
		if(nums.length == 1) return ;
		int i = 0, pos = 0;
		for(i=nums.length-2; i>=0; i--) {
			if(i+1 < nums.length && nums[i+1] <= nums[i]) continue; //keep ascending order, continue
			else break;
		}
		if(i < 0) { // sort with ascending
			Arrays.sort(nums);
			return ;
		}
		else { // change the pos to min-number of substring(pos+1)
			pos = i; 
			int min = Integer.MAX_VALUE, min_j = -1;
			for(int j=pos+1; j<nums.length; j++) {
				if(nums[j] < min && nums[j] > nums[pos]) {
					min = nums[j];
					min_j = j;
				}
			}
			//exchange the number
			int temp = nums[min_j];
			nums[min_j] = nums[pos];
			nums[pos] = temp;
			//sort the substring(pos+1)
			Arrays.sort(nums, pos+1, nums.length); // sort from pos+1 to nums.length-1
			return ;
		}
    }
}
