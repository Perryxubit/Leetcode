/*
    找到给定数字在字典序中的下一个排列，本题看起来有些难度，但是深入理解后就知道大概怎么处理了。
    比如给出1 2 5 4, 找出比这个序列大一点的下一个序列，即1 4 2 5，如果下一个序列不存在，则把该序列重新升序排列。
    据说这是个经典问题... 我用的比较蠢的解法，不知道还有没有什么更好的方法
    
    对于给定数组nums, 从后向前遍历，找出不满足降序排列(其实此处是非升序，包括等于)的第一个数字，
    比如1 2 5 4 3中5>4但2<5, 所以5 4 3 是降序序列，但2 5 4 3不是降序。
    所以我们把2这位数组替换为nums中2之后最小的值进行交换, 对于1 2 5 4 3数组，2之后的元素最小的是3，所以交换后序列为1 3 5 4 2。
    此外，还需要把原数组中2对应的位置之后的元素序列进行重排序, 即在交换后的序列中还要把5 4 2重排为 2 4 5，得到最终的序列 1 3 2 4 5。
    
    当然，如果后续降序遍历时没有找到不满足降序排列的数组，则直接对数组升序重排即可，详情见代码。

*/

public class Solution {
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
