/*
	这次终于轮到了经典的N皇后问题！
	N皇后是说在N*N的棋盘上放置N个皇后，让她们各自谁也无法吃掉谁。(我们可能经常可以听到8皇后问题，其是N皇后问题的一个特例)
	对于这类问题，方法还是回溯法，用递归的方式来找到可能的解：
	先确定N*N矩阵的每一行的皇后位置，然后再递归试探下一层可能满足条件的皇后的位置，
	以此类推，如果直到第N层皇后都有可能满足条件的位置，则这是N皇后问题的一个可行解！将其加入结果集中。

	实现起来并不难，要注意的是位置<x, y>的皇后是否满足条件的函数validQueens，我在这里就是简单的把横向/纵向/斜向的格子都遍历一遍，
	如果有第二个Queen就返回false。
	此外，回溯时还要注意把当前格子设置为空(queens[i][j] = ".";)。
	时隔多年再做这类N皇后问题，感觉并不那么难，看来比在学校时还是有一些进步。
	
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		String[][] queens = new String[n][n];
		for(int i=0; i<n; i++) { //initializethe queens array
			for(int j=0; j<n; j++) {
				queens[i][j] = ".";
			}
		}
		recursion(result, queens, 0, n);
		return result;
    }
	
	void recursion(ArrayList<List<String>> result, String[][] queens, int x, int n) {
		if(x >= n) { // if all row has valid Queen, then this is a new solution
			ArrayList<String> solution = new ArrayList<String>();
			String row = "";
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					row += queens[i][j];
				}
				solution.add(row);
				row = "";
			}
			result.add(solution);
			return ;
		}
		for(int j=0; j<n; j++) { // check possibilities for Queen set in row:x 
			queens[x][j] = "Q"; // set Queen in <x,j>
			if(validQueens(queens, x, j, n)) {
				recursion(result, queens, x+1, n); // find next Queen in next row
			}
			queens[x][j] = "."; // Back Trace
		}
		return ;
	}
	
	boolean validQueens(String[][] queens, int x, int y, int n) {
		//check the validation for row:x  column:y
		int numQ_row = 0, numQ_col = 0;
		for(int i=0; i<n; i++) {
			//check row
			if(queens[x][i].equals("Q")) numQ_row++;
			if(queens[i][y].equals("Q")) numQ_col++;
		}
		if(numQ_col > 1 || numQ_row > 1) return false;
		int numQ_slant = 0;
		for(int delta=0; x+delta<n&&y+delta<n; delta++) // right bottom
			if(queens[x+delta][y+delta].equals("Q")) numQ_slant++;
		for(int delta=0; x-delta>=0&&y-delta>=0; delta++) // left top
			if(queens[x-delta][y-delta].equals("Q")) numQ_slant++;
		for(int delta=0; x+delta<n&&y-delta>=0; delta++) // right top
			if(queens[x+delta][y-delta].equals("Q")) numQ_slant++;
		for(int delta=0; x-delta>=0&&y+delta<n; delta++) // left bottom
			if(queens[x-delta][y+delta].equals("Q")) numQ_slant++;
		if(numQ_slant > 4) return false;
		//valid:
		return true;
	}
}
