/*


*/

public boolean canJump2(int[] nums) {
		//Greedy
		int arrive = 0;
		for(int i=0; i<nums.length; i++) {
			if(i > arrive) break;
			if(nums[i]+i > arrive) arrive = nums[i]+i;
		}
		if(arrive >= nums.length-1) return true;
		return false;
    }
	
	public boolean canJump(int[] nums) {
		//DFS, recursion
		int current = 0;
        return recursion(nums, current);
    }
	public boolean recursion(int[] nums, int current) {
		if(current >= nums.length) return true;
		else {
			for(int i=nums[current]; i>=1; i--) {
				if(recursion(nums, current+i) == true) return true;
				else return false;
			}
		}
		return false;
	}
