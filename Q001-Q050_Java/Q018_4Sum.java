/*
    类似3-Sum和2-Sum中的O(NlogN)方法
    O(N^3)方法：先排序后，依次固定P和Q，然后使用left和right指针从头尾依次遍历，如果nums[left]+nums[right]+P+Q之和等于target，则加入结果集，
    否则根据类似3-Sum和2-Sum的方法移动left和right指针。
    
    类似地，可以扩展到5-Sum, 6-Sum, 7-Sum, ..., K-Sum问题:
    当K=2时，最快时间复杂度为O(NlogN);
    当K>2时，最快的时间复杂度为O(N^(K-1));
    
*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // sort from small to large
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//time complexity: O(N^3)
		for(int i=0; nums.length>=4 && i<nums.length-3; i++) {
			int P = nums[i];
			if(i>0 && nums[i-1] == nums[i]) continue; //P cannot be repeated (only if i > 0, it is P)
			for(int j=i+1; j<nums.length-2; j++) {
				int Q = nums[j];
				if(j>i+1 && nums[j-1] == nums[j]) continue; // Q cannot be repeated (only is j> i+1, it is Q)
				int left = j+1, right = nums.length-1;
				while(left < right) {
					if(left == i || left == j) {
						left++;
						continue;
					}
					if(right == i || right == j) {
						right--;
						continue;
					}
					//check the current SUM:
					if(nums[left] + nums[right] + P + Q == target) { // sum is target, store in list:
						List<Integer> group = new ArrayList<Integer>();
						group.add(P);
						group.add(Q);
						group.add(nums[left]);
						group.add(nums[right]);
						list.add(group);
						while(left<right && left+1<nums.length && nums[left] == nums[left+1]) left++; //pass same number from right
						while(left<right && right-1>=0 && nums[right] == nums[right-1]) right--; //pass same number from left
						left++;
						right--;	
					}
					else if(nums[left] + nums[right] + P + Q < target) // if the sum is smaller than target, need bigger number, move left pointer
						left++;
					else if(nums[left] + nums[right] + P + Q > target) // if the sum is larger than target, need smaller number, move right pointer
						right--;
				}
			}
		}
    	return list;
    }
}
