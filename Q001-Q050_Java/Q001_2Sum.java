/*
  本题有多种方法，O(N^2)的, O(NLOGN)的，以及O(N)的，
  O(N^2)方法最简单(即下文源代码中的twoSum_1)，两次循环遍历，暴力方法解决。
  O(NLOGN)方法(即下文源代码中的twoSum_2)则需要对输入数组进行排序，在排好序后从数组两头用2个指针left和right开始同时遍历，
    如果2者之和大于target，则表示right需要左移，取更小的数；如果2者之和小于target，则表示left需要右移，取更大的数；
    遍历过程可以在O(N)内完成，但是由于需要排序，所以时间复杂度为O(NLOGN)。
    需要注意的是本题要返回数组下标，所以在排序之前必须想办法把数组中每个数据的位置存起来。我用的是hash方式来存储，由于本题说过结果只有一个solution，
    则说明数组中不会超过2个重复的值，如数组{3,3}，求和为6，可以找到3+3=6是唯一解，如果是{3,3,3}求和为6，便不符合题意了，所以本题只考虑2个重复即可。
    具体实现的方法小技巧请查看源代码
  O(N)方法(即下文源代码中的twoSum_3)使用hash的方法更加迅速的定位：将数组中数放入hash表中，
    依次遍历数组中每个数Ni，如果target-Ni也在hash表中的话，则将Ni和target-Ni返回即可。
    
*/

public class Solution {
    public int[] twoSum_1(int[] nums, int target) {
        int[] rev = new int[2];
        //Time Complexity: O(N^2)
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    rev[0] = i;
                    rev[1] = j;
                    return rev;
                }
            }
        }
        return rev;
    }
	
    public int[] twoSum_2(int[] nums, int target) {
        int[] rev = new int[2];
        int left = 0, right = nums.length-1;
        //Time Complexity: O(NlogN)
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<nums.length; i++) {
        	if(map.get(nums[i]+"") != null) 
        		map.put(nums[i]+"##", i); // repeat value
        	else map.put(nums[i]+"", i);
        }
        Arrays.sort(nums); // sort from smaller one to larger one
        while(left < right) {
        	if(nums[left] + nums[right] == target) {
        		rev[0] = map.get(nums[left]+"");
        		if(nums[left] == nums[right]) { // only consider two repeat numbers is enough
        			rev[1] = map.get(nums[right]+"##");
        		}
        		else rev[1] = map.get(nums[right]+"");
        		return rev; // only one solution
        	}
        	else if(nums[left] + nums[right] > target) { // larger than target, need smaller entry!
        		right--;
        	}
        	else { // smaller than target, need larger entry!
        		left++;
        	}
        }
        return rev;
    }
    
    public int[] twoSum_3(int[] nums, int target) {
        int[] rev = new int[2];
        //Time Complexity: O(N)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); //store the number of array
        for(int i=0; i<nums.length; i++) {
        	if(hm.containsKey(target - nums[i])) { // if hashmap contains target-Ni, then return the pair
        		rev[1] = i;
        		rev[0] = hm.get(target - nums[i]);
        		return rev; // only one solution
        	}
        	hm.put(nums[i], i);
        }
        return rev;
    }
}
