/*
      感觉本题其实是个画图题... 例如，将{1 2 3 4 5 6 7 8 9 0} 按照nRows=4来排列，得到：
           1    7
           2  6 8 
           3 5  9
           4    0  
      本题我定义了二维数组，按照ZigZag的规则，按照字母N的形状，将数字排列到二维数组中..然后横向打印即可，简单的画图问题。
      对二维数组来说，如果给定numRows过于大，则数组会因为包含很多0而使空间复杂度很差.. 
      此外，还有一些公式法可以更省空间完成本题，不过我在这里不再深入研究了。
  
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s; // same output if numrows = 1
        int x_len = 0; // length of array_X : x_len
        if(s.length()%(2*numRows-2) <= numRows)
        	x_len = (s.length()/(2*numRows-2))*(numRows-1) + 1;
        else 
        	x_len = (s.length()/(2*numRows-2))*(numRows-1) + (s.length()%(2*numRows-2)) - numRows + 1;
        char[][] array = new char[numRows][x_len];
        int input_y = 0, input_x = 0;
        for(int i=0; i<s.length(); i++) {
        	array[input_y][input_x] = s.charAt(i);
        	if(input_x == 0 || input_x%(numRows-1) == 0) input_y++; //each special columns, just y++
        	else { //other columns, y--, x++
        		input_y--;
        		input_x++;
        	}
        	if(input_y == numRows) { //y hit the bottom, then y-=2, x++
        		input_y = numRows - 2;
        		input_x++;
        	}
        }
        
        char[] rev = new char[s.length()];
        int index = 0;
        for(int i=0; i<numRows; i++) {
        	for(int j=0; j<x_len; j++) {
        		if(array[i][j] != 0) rev[index++] = array[i][j];
        	}
        }
        return String.valueOf(rev);
    }
}
