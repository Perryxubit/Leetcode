/*
    本题类似Q054，Q054是给出一个矩阵，求出螺旋读取的序列。
    而本题给出一个N，构造出N*N的螺旋矩阵。
    算法是相近的...而且本题由于只生成N*N的正方形矩阵，所以可能更容易处理一些...
    具体方法参考如下程序，注意如果N是奇数的话要多增加矩阵中心的一个元素, 否则会缺失...

*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 1) {
        	matrix[0][0] = 1;
        	return matrix;
        }
        int count = 1, k = 0;
        while(count <= n*n) {
        	for(int i=k; i<n-k-1 && count <= n*n; i++) {
        		matrix[k][i] = count++; 
        	}
        	for(int i=k; i<n-k-1 && count <= n*n; i++) {
        		matrix[i][n-k-1] = count++;
        	}
        	for(int i=n-k-1; i>=k+1 && count <= n*n; i--) {
        		matrix[n-k-1][i] = count++;
        	}
        	for(int i=n-k-1; i>=k+1 && count <= n*n; i--) {
        		matrix[i][k] = count++;
        	}
        	k++;
        	
        	if(count == n*n && n%2!=0) {
        		matrix[k][k] = count++;
        	}
        }
        
        return matrix;
    }
}
