/*
    本题是Q15. 3Sum的延伸。
    O(N^2)方法：依然采用相同的方法处理，对于数组中每个元素num[i]，在剩下元素中用left和right两个指针从头尾向中间移动。
    不同的是每次用nums[left]+nums[right]+num[i]，我们都要比较其是否更接近target。
    我的比较方法是设定delta值，通过nums[left]+nums[right]+num[i]-target的绝对值的方式计算delta，
    delta最小时即是nums[left]+nums[right]+num[i]最接近target的时候。
    具体实现请看代码。
    
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        	Arrays.sort(nums); // sort from small to large
		int delta = Integer.MAX_VALUE, closest = -1;
        	for(int i=0; i<nums.length; i++) {
			int P = nums[i], left = i+1, right = nums.length-1;
			while(left < right) {
				if(left == i) { // pass if left = i
					left++;
					continue;
				}
				if(right == i) { // pass if right = i
					right--;
					continue;
				}
				if(nums[left] + nums[right] + P == target) {
					return target; // equal, then return target
				}
				else if(nums[left] + nums[right] + P < target) {
					// if the sum is smaller than target, need bigger number, move left pointer
					if(Math.abs(target - (nums[left] + nums[right] + P)) < Math.abs(delta)){
						delta = target - (nums[left] + nums[right] + P); //closer to target ()
						closest = nums[left] + nums[right] + P;
					}
					left++;	
				}
				else if(nums[left] + nums[right] + P > target) {
					// if the sum is larger than target, need smaller number, move right pointer
					if(Math.abs(target - (nums[left] + nums[right] + P)) < Math.abs(delta)) {
						delta = target - (nums[left] + nums[right] + P); //closer to target ()
						closest = nums[left] + nums[right] + P;
					}	
					right--;
				}
			}
		}
		if(target != Integer.MAX_VALUE) return closest;
		else return 0;
    }
}
