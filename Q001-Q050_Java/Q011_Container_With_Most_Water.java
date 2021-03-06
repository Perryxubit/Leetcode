/*
      本题题意可能不好懂，它要给出一个高度数组，求任意两个高度的木板组成的木桶的最大容积 (其实就是正方形的最大面积)
      O(N^2)方法：暴力搜索，超时。
      O(N)方法: 模仿Q1.2Sum问题的O(NlogN)解法，让两个指针left和right分别指向头尾，并计算面积maxArea，
      然后移动left和right，规则为：
      我们要求最大面积，所以需要更长的边，我们可以舍弃left和right中较短的边，让短边的指针向中间移动。
      用这种贪心方法让left和right向中间移动，直到重合后，返回这个过程中的最大值即可。

*/

public class Solution {
  public int maxArea(int[] height) {
    int maxArea = 0, left = 0, right = height.length-1;
		while(left < right) {
			int shorter = 0;
			if(height[left] < height[right]) {
				shorter = height[left];
				int area = (right - left) * shorter;
		    	maxArea = area>maxArea?area:maxArea;
				left++;
			}
			else {
				shorter = height[right];
				int area = (right - left) * shorter;
		    	maxArea = area>maxArea?area:maxArea;
				right--;
			}
		}
		return maxArea;
    }
}
