/* 
  对给定矩阵进行螺旋输出..
  比如给定矩阵
  1  2  3  4
  5  6  7  8
  9 10 11 12
  输出序列 1 2 3 4 8 12 11 10 9 5 6 7 
  
  算是简单的遍历问题，对四个方向(右、下、左、上)依次遍历即可，要注意给的矩阵是M*N，可能有各种组合，输出不对的话就自己debug吧..

*/

public class Solution {
   public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        int M = matrix.length;
        int N = matrix[0].length;
        int k = 0, loop = (M<N?M:N)/2;
        
        while(k < loop) {
        	for(int i=k; i<N-k-1; i++) {
        		result.add(matrix[k][i]);
        	}
        	for(int i=k; i<M-k-1; i++) {
        		result.add(matrix[i][N-1-k]);
        	}
        	for(int i=N-k-1; i>=k+1; i--) {
        		result.add(matrix[M-1-k][i]);
        	}
        	for(int i=M-k-1; i>=k+1; i--) {
        		result.add(matrix[i][k]);
        	}
        	k++;
        }
        
        if(loop < 1 || ((M<N?M:N)%2) != 0) {
        	if(M > N) {
        		for(int i=k; i<M-k; i++)
        			result.add(matrix[i][k]);
        	}	
        	else {
        		for(int i=k; i<N-k; i++)
        			result.add(matrix[k][i]);
        	}     
        }
        
        return result;
    }
}
