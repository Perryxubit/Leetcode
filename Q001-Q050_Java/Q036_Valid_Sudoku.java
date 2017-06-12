/*
    关于数独的题，题目要求检查数独矩阵是否满足要求。
    注意！！！！ 本题只是简单的检查矩阵是否满足要求，不是让你求解数独！(求解的问题在Q037)
    第一次想复杂了 写好了怎么也过不了，结果发现是让你judge数独矩阵是否满足要求，而不是该矩阵是否可解....
    基本判断数独矩阵就3个规则：每一行数字不能重复，每一列数字不能重复，矩阵内9个小正方形内的9个小格子的数字不能重复，
    直接用规则搜索即可...我反正还没找出什么新方法。

*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
		//check whether the sodoku question is valid or not (just check the existing number is enough!!!)
		//Don't need to check whether the sodoku can be resolved! only check the validation of the sodoku...
		HashSet<Character> set = new HashSet<Character>();
		//1. check the row
		for(int x=0; x<9; x++) {
			set.clear();
			for(int j=0; j<9; j++) {
				if(board[x][j] == '.') continue;
				else {
					if(!set.contains(board[x][j])) {
						set.add(board[x][j]);
					}
					else return false; //repeat number in same row
				} 
			}	
		}
		//2. check the column
		for(int y=0; y<9; y++) {
			set.clear();
			for(int i=0; i<9; i++) {
				if(board[i][y] == '.') continue;
				else {
					if(!set.contains(board[i][y])) {
						set.add(board[i][y]);
					}
					else return false; //repeat number in same column
				} 
			}	
		}				
		//3. check the square
		for(int ki=0; ki<3; ki++) { 
			for(int kj=0; kj<3; kj++) {
				//9 blocks
				set.clear();
				for(int i=ki*3; i<ki*3+3; i++) {
					for(int j=kj*3; j<kj*3+3; j++) {
						if(board[i][j] == '.') continue;
						else {
							if(!set.contains(board[i][j])) {
								set.add(board[i][j]);
							}
							else return false; //repeat number in same square
						} 
					}
				}	
			}	
		}					
		
		return true;
	}
}
