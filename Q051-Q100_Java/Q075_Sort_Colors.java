/*
  这题...我感觉是最简单的... 对数组排序，数组中的元素只有N种(本题为3，即0，1和2).
  我定义3个变量..分别记录这3种元素出现的次数...然后依次覆盖原数组即可...
  总觉得这题没这么简单? 不管咋样已经A了... 而且性能还可以: O(N)
  
*/

public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) red++;
            if(nums[i] == 1) white++;
            if(nums[i] == 2) blue++;
        }
        int index = 0;
        for(int i=0; i<red; i++) nums[index++] = 0;
        for(int i=0; i<white; i++) nums[index++] = 1;
        for(int i=0; i<blue; i++) nums[index++] = 2;
    }
}
