/*
    与上一道题(Q051)一模一样，还不需要给具体的摆放结果了。(把具体的解的格式输出即可)
    这里投机取消把上一道题的代码来用用...
    如果有新方法(不用回溯的)，后面在研究~
    
*/

public class Solution {
	//using Q051 solution to pass this question...
    public int totalNQueens(int n) {
		int[] solution = new int[1];
		String[][] queens = new String[n][n];
		for(int i=0; i<n; i++) { //initializethe queens array
			for(int j=0; j<n; j++) {
				queens[i][j] = ".";
			}
		}
		recursion2(solution, queens, 0, n);
		return solution[0];
    }
	
	void recursion2(int[] solution, String[][] queens, int x, int n) {
		if(x == n) { // if all row has valid Queen, then this is a new solution
			solution[0]++;
			return ;
		}
		for(int j=0; j<n; j++) { // check possibilities for Queen set in row:x 
			queens[x][j] = "Q"; // set Queen in <x,j>
			if(validQueens(queens, x, j, n)) {
				recursion2(solution, queens, x+1, n); // find next Queen in next row
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
