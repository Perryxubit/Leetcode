/*
    本题要在二维数组里搜索数字, 这个二维数组每行是有序的，每列也是有序的...不难。
    O(N*M):暴力搜索...不去实现了
    O(M+logN): 为了变快，我本来先找到对应的列，然后在该行里进行二分查找，如下文searchMatrix(int[][] matrix, int target)函数
    O(logM+logN): 再快一些...我发现查找列上也可以二分...所以写2个binary search即可，如下文searchMatrix2(int[][] matrix, int target)函数
    O(log(M+N)):  其实不用把数组当成2维的，2唯数组本质也是1唯的，这题完全可以看成"在一唯有序数组中查找数字"，一个binary search我觉得就可以了。
    不过没实现这种方式，这个应该是最快的，只二分查找一次，即O(log(M+N))，以后有空会来实现的。
    
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		
        int k = 0, m = matrix[0].length;
		//find the right row
        while(k < matrix.length && target >= matrix[k][0]) k++;
        if(k != 0) k--;
       
        //then binary search
		int left = 0, right = m-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(matrix[k][mid] == target) 
				return true;
			else if(matrix[k][mid] > target) 
				right = mid - 1;
			else left = mid + 1;
		}
		return false;
    }
    
    public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = m-1;
		int row = -1;
        
		//Column: binary search
        while(left <= right) {
        	int mid = (left + right)/2;
        	if(target == matrix[mid][0]) {
        		row = mid;
        		break;
        	}
        	else if(target < matrix[mid][0] ) right = mid-1; // search up
        	else { // search down
        		if(row < mid) row = mid;
        		left = mid+1; 
        	}
        }
        if(row == -1) return false; // not found in column
       
        //Row: binary search
        left = 0; 
        right = n-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(matrix[row][mid] == target) return true; // find it
			else if(target < matrix[row][mid])  right = mid - 1; // search up
			else left = mid + 1;
		}
		
		return false;
    }
}
