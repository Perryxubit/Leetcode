/*
    类似于Q062的DP解法，不同的是本题给了一个障碍矩阵来限制移动。(移动时如果碰到障碍则不能继续移动)
    本题的解法实现起来还是一样的...稍微麻烦一点的就是移动时要判断是否有障碍，所以在填写动态规划矩阵时要注意有障碍不要相加就好了，
    如果某一点的上方和左方都有障碍，则该点的路径数为0...
    了解Q062的解法的话本题还是很简单的，时间复杂度O(M*N)。

*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int M = obstacleGrid.length, N = obstacleGrid[0].length;
		int[][] path = new int[M][N]; 
        for(int i=0; i<M && obstacleGrid[i][0]!=1; i++) //first column, path to each entry -> 1 
        	path[i][0] = 1; 
        for(int i=0; i<N && obstacleGrid[0][i]!=1; i++) //first row, path to each entry -> 1
        	path[0][i] = 1;
        
        for(int i=1; i<M; i++) {
        	for(int j=1; j<N; j++) {
        		if(obstacleGrid[i][j] == 1) path[i][j] = 0;
        		else if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1) path[i][j] = 0;
        		else if(obstacleGrid[i-1][j] == 1) {
        			path[i][j] = path[i][j-1];
        		}
        		else if(obstacleGrid[i][j-1] == 1) {
        			path[i][j] = path[i-1][j];
        		}
        		else path[i][j] = path[i-1][j] + path[i][j-1];
        	}
        }
        
        if(obstacleGrid[M-1][N-1] == 1) return 0;
        else return path[M-1][N-1];
    }
}
