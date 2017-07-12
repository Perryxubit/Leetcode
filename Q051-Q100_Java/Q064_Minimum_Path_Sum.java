/*
    本题是Q062和Q063的再次延伸...给一个数字矩阵，求数字和最小的路径...
    比如给定数字矩阵grid:
    1 5 3 9 0
    7 2 2 1 5
    5 3 4 1 9
    我们可以根据这个构建path数组: (每一个元素都是从左上角的点到该点元素路径数字的和)
     1   6   9  18  18
     8   8  10  11  16
    13  11  14  12  21
    每一个点(X, Y)的值取决于该点在grid中的值与该点上方(X-1, Y)和左方(X, Y-1)最小值的和。
    实现如以下代码所示，时间复杂度还是O(M*N)。
    
*/

public class Solution {
    public int minPathSum(int[][] grid) {
		int M = grid.length, N = grid[0].length;
		int[][] path = new int[M][N];
		path[0][0] = grid[0][0];
		for(int i=1; i<M; i++) //first column
        	path[i][0] = path[i-1][0] + grid[i][0]; 
		for(int i=1; i<N; i++) //first row
        	path[0][i] = path[0][i-1] + grid[0][i]; 
		for(int i=1; i<M; i++) {
        	for(int j=1; j<N; j++) {
        		if(path[i][j-1] < path[i-1][j]) path[i][j] = path[i][j-1] + grid[i][j];
        		else path[i][j] = path[i-1][j] + grid[i][j];
        	}
        }
        
        return path[M-1][N-1];	
	}
}
