/*
    本题要求搜索矩阵，如果某个一个元素matrix[i][j]是0，则将第i行和第j列所有元素全部置为0。
    假如遍历时修改矩阵，可能会对后续的遍历造成影响，所以我们必须遍历之后再置0。
    本体限制了空间复杂度，
    Space O(M*N)算法: 最蠢的，构造另一个M*N的矩阵，遍历原来矩阵时将新矩阵置为0即可，太蠢不去实现了。
    Space O(M+N)算法：如下文的public void setZeroes(int[][] matrix)函数，在遍历过程中我定义了hashset集合，把所有应该置为0的行和列分别存在
    行集合与列集合中，最后遍历完统一置0。但是O(M+N)的方法还能继续提升。
    Space O(1)算法：巧妙地方式是，不额外申请空间存储行和列中是否包含0，而是把原始矩阵matrix的第一行和第一列拿出来，用来标记该行/列是否出现过
    值为0的元素。但是对于这种方法，我们必须先设置2个bool变量记录一下第一行和第一列是否本身就包含0，否则在最后置0的过程中第一行和第一列就无法
    判断了... 具体方法详见下文的public void setZeroes2(int[][] matrix)函数。

*/

public void setZeroes(int[][] matrix) {
		//Space: O(m+n)
		HashSet<Integer> row = new HashSet<Integer>();
		HashSet<Integer> column = new HashSet<Integer>();
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row.add(i);
					column.add(j);
				}
			}
		}
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(row.contains(i) || column.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
    }
	
public void setZeroes2(int[][] matrix) {
		//space: O(1)
		//use first column and row to mark the zeros!
		boolean firstRow_0 = false, firstColumn_0 = false;
		for(int i=0; i<matrix[0].length; i++)
			if(matrix[0][i] == 0) firstRow_0 = true; // first row has 0
		for(int i=0; i<matrix.length; i++)
			if(matrix[i][0] == 0) firstColumn_0 = true; // first column has 0
		
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if(firstRow_0 == true) 
			for(int i=0; i<matrix[0].length; i++) matrix[0][i] = 0;
		if(firstColumn_0 == true)
			for(int i=0; i<matrix.length; i++) matrix[i][0] = 0;
    }
