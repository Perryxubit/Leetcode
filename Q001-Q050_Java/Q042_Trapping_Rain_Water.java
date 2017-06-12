/*
    又一道两头遍历的问题，可以在O(N)方法解。
    本题要求给一个高度数组，求该数组可以围成的栅栏的盛水体积(其实就是长乘以宽，不是真正体积)。
    
    给2个指针left和right，依次往中间移动：
    比较left和right位置的高度，移动高度较短的一边(因为只有最短短边才决定水桶的体积)。
    假如移动left边，在移动的过程中如果移动后的left边高度小于【本次移动过程开始之前初始的left边】，则把当前的水的体积计算累加起来，
    依次移动left边直到left比right高，然后移动right边。
    最后left=right时结束，得到最终体积。
    文字不好表达..大家自己画画图就知道什么意思了。

*/

public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1, result = 0;
        while (left < right) {
        	if(height[left] <= height[right]) { // move left pointer
        		int preHeight = height[left];
        		left++;
        		while(height[left] < preHeight) {
        			result += (preHeight - height[left]);
        			left++;
        		}
        	}
        	else { // move right pointer
        		int preHeight = height[right];
        		right--;
        		while(height[right] < preHeight) {
        			result += (preHeight - height[right]);
        			right--;
        		}
        	}   	
        }
		return result;
    }
}
