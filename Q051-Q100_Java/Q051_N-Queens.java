


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
