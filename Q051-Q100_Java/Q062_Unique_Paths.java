/*
    本题要求给定一个M*N的矩阵，求从左上角(1, 1)走到右下角(M, N)的路径有多少种。移动时只能向右/向左移动。
    本来用DFS来做... 但是递归超时了... 后来看了分析发现这类问题其实是最经典的动态规划(DP)问题...
    对于矩阵中的某一个点(X, Y)来说，从(1, 1)到该点的路径等于从(1, 1)到点(X-1, Y)和从(1, 1)到点(X, Y-1)的路径数量的和。
    所以我们可以初始化一个路径记录矩阵path, 由于只能向右向下移动，所以path矩阵第一行和第一列的路径数都为1， 例如：
    M = 3, N = 5:
    1 1 1 1 1
    1 0 0 0 0
    1 0 0 0 0
    对于矩阵中的其他元素，我们可以根据该元素位置的上方元素和左侧元素来计算当前元素。 最终填满的矩阵为：
    1  1  1  1  1
    1  2  3  4  5
    1  3  6  10 15
    我们可以看到(M, N)位置的路径数为15，即为结果所求。
    用DP的话, 时间复杂度为O(M*N)。

*/

public class Solution {
   public int uniquePaths(int m, int n) {
		//DP
		int[][] path = new int[m][n]; 
        for(int i=0; i<m; i++) //first column, path to each entry -> 1 
        	path[i][0] = 1; 
        for(int i=0; i<n; i++) //first row, path to each entry -> 1
        	path[0][i] = 1; 
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		path[i][j] = path[i-1][j] + path[i][j-1];
        	}
        }
        return path[m-1][n-1];
    }
}
