/*
    3-SUM问题，在2-SUM的基础上增加一维。
    O(N^3)方法，暴力遍历三层循环，结果会TLE, 无法A这道题。
    O(N^2)方法，参考我在Q1.TwoSum中的方法2，
    对于2-SUM问题，该方法时间复杂度为O(NlogN)，是因为他需要先排序，
    而对于3-SUM问题，在排序之后，我们先遍历数组，将nums[i]作为确定值，用类似2-SUM的方法：
        使用头尾指针left和right依次向中间移动，找nums[left]+nums[right] == target-nums[i]的组合。
        如果nums[left]+nums[right] >= target-nums[i]，则需要小一点的值，left移动，否则right移动。
        需要注意的是如果找到了满足条件的组合，还需要让left/right指针继续移动，因为本题要找出所有满足条件的不同解，
        在移动过程中，如果有连续相同的元素(因为排过序了，所以相同元素一定相邻)，则要逐个跳过，否则不跳过则会在结果中出现相同解。
    注意：本题默认target为0。
    
*/

public class Solution {
   	public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums); // sort from small to large
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		//time complexity: O(N^2)
		for(int i=0; i<nums.length; i++) {
			int P = nums[i], left=i+1, right=nums.length-1;
			if(i-1>=0 && nums[i] == nums[i-1]) continue; // if the number is the same as last one, then pass
			while(left < right) {
				if(left == i) { // pass if left = i
					left++;
					continue;
				}
				if(right == i) { // pass if right = i
					right--;
					continue;
				}
				// for each nums[i], using left/right to search from both head and tail
				if(nums[left] + nums[right] + P == 0) { //if the sum is equal to 0, then add to list
					//add into list
					List<Integer> group = new ArrayList<Integer>();
					group.add(P);
					group.add(nums[left]);
					group.add(nums[right]);
					list.add(group);
					while(left<right && left+1<nums.length && nums[left] == nums[left+1]) left++;
					while(left<right && right-1>=0 && nums[right] == nums[right-1]) right--;
					left++;
					right--;
				}
				else if(nums[left] + nums[right] + P < 0) // if the sum is smaller than 0, need bigger number, move left pointer
					left++;
				else if(nums[left] + nums[right] + P > 0) // if the sum is larger than 0, need smaller number, move right pointer
					right--;
			}
		}
		//System.out.println(list.size());
		return list;
	}
}
