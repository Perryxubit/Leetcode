/*
    致敬经典问题！！！
    本题是真正让你解决数独问题了..并且题目假设给的数独矩阵一定有解且解是唯一的，是个经典的并且有意思的题。
    基本想法就是回溯法, 我是用人类正向解题思维的方式去实现的代码，可能还有更好的方法，我还没有更深入研究。
    
    PS:数独规则
    对于一个数独问题，我们需要在9*9的空格内填入数字。这9*9被分成9个3*3的小块N1 - N9，要保证每个小块Ni包含的数字必须是1至9，不能重复。
    同时，9*9的矩阵每一行和每一列都不能用重复数字。
    
    解题思路：
    拿到一个数独问题，我会计算每个空格可能选取的数字集合，比如对位置为(i, j)的空格来说，要看其第i行和第j列以及(i,j)所属于的小块Ni都不包含的数字，
    这些数字组成的集合就是当前(i, j)可能选取的数字。
    所以对于数独9*9矩阵中的每一个待填空格(本题用'.'表示空格)， 我们都先求其可能选取的数字组合。
    (由于数字只可能是1-9，所以我的代码中用字符串变量possible来表示这个组合，方便以后处理)
    对于possible中的每一个可能数字，我们把其填入当前格中，然后通过递归的方式判断下一个待填空格的可能填入的数字。
    如果所有空格都可以完美的填上，那么这就是数独的解。
    如果进行到某一步时发现可能选取的数字组合possible为空，就说明这个情况是不满足数独规则的，需要回溯。
    回溯时将当前填上的空格恢复为空即可(即设为'.')
    同时因为本题只求一个解，所以遇到一种情况成功(所有空格都被填满)就返回true就好。

*/

public class Solution {
    public void solveSudoku(char[][] board) {
		if(board.length == 0) return;	
        boolean canbeSolved = resolveSudoku(board);
//      System.out.println("Can be resolved? " + canbeSolved);
    }
	
	public boolean resolveSudoku(char[][] board) {
		for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		if(board[i][j] == '.') {
        			String possible = getPossibleNumber(board, i, j); // get available possible number array for that certain position(i, j)
        			for(int k=0; k<possible.length(); k++) {
        				// put possible.charAt(k) in board[i][j], and perform recursion again
        				board[i][j] = possible.charAt(k);
        				boolean SudokuCanBeSolved = resolveSudoku(board);
        				//Judge if the Sudoku can be resolved with current possibility in possible array
        				if(SudokuCanBeSolved == true) return true; // solution is found!!!  then returns with true 
        				else board[i][j] = '.'; // cannot be resolved, then roll back, then try next posibility in possible array
        			}
        			// all possible numbers in current number range can not solve the Sodoku, then roll back with returning false
        			return false;
        		}
        	}
        }
		//the traverse for 9*9 matrix is finish, and no more empty (with symbol '.') in the current matrix, 
		//then this is the solution! return true!
		return true;
    }
	
	public String getPossibleNumber(char[][] board, int x, int y) {
		//x: index of row, get possible number for row
		String appe = "", rec = "";
		for(int i=0; i<9; i++) {
			if(board[x][i] != '.') 
				appe += board[x][i];
		}
		//y:index of column, get possible number for column
		for(int i=0; i<9; i++) {
			if(board[i][y] != '.') 
				appe += board[i][y];
		}
		// check possible number for square
		for(int i=3*(x/3); i<3*(x/3)+3; i++) {
			for(int j=3*(y/3); j<3*(y/3)+3; j++) {
				if(board[i][j] != '.') 
					appe += board[i][j];
			}
		}
		//get the non-appear number (possible number)
		for(int i=1; i<=9; i++) {
			if(!appe.contains("" + i)) {
				rec += ("" + i);
			}
		}	
		return rec;
	}
}
