/*
    矩阵旋转问题, 第一种方法就是直接新建矩阵把每一个数字放进去，见我的rotate函数所示。
    
    但是题目要求用数字替换的方式，不能申请额外空间，这其实是个线性代数问题...查了一下翻转方法，对矩阵翻转问题是有共同解的：
    - 对于逆时针翻转， 我们先把每一行的几个数字左右反转，然后再对矩阵进行对角反转即可。
    1 2 3        3 2 1       3 6 9
    4 5 6   ->   6 5 4   ->  2 5 8
    7 8 9        9 8 7       1 4 7
    - 对于顺时针翻转， 我们把行的排列进行反转，然后再对矩阵进行对角反转即可。
    1 2 3        7 8 9       7 4 1
    4 5 6   ->   4 5 6   ->  8 5 2
    7 8 9        1 2 3       9 6 3
    这样就可以在不申请额外数组的情况下完成翻转。
    第二种方法见代码rotate2函数。
    
*/

public class Solution {
    public void rotate(int[][] matrix) {
		int N = matrix.length;
        int[][] newmatrix = new int[N][N];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		newmatrix[j][N-i-1] = matrix[i][j];
        	}
        }
        for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				matrix[i][j] = newmatrix[i][j];
		}
    }
	
	public void rotate2(int[][] matrix) {
		int N = matrix.length;
		for(int i=0; i<=N/2-1; i++) {
			//swap line i and N-i-1 
			for(int j=0; j<N; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N-i-1][j];
				matrix[N-i-1][j] = temp;
			}
		}
        for(int i=0; i<N; i++) {
        	for(int j=i+1; j<N; j++) { //only swap the bottom half is enough
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
    }
}
