/*
      题目本身是非常容易的AtoI的实现 (字符串转整数)，
      但是... 题目有各种意想不到的输入要处理...所以要投入不少精力改BUG ...
      具体不赘述了，见我的程序，要注意的是:
      1. 输入可以为负数
      2. 有什么无法转化的字符或者规则，则返回0
      3. 输入有乱七八糟的字符..但是要注意第一个非数字字符之前的数字都必须转化
      4. 输入有空格....
      总之.. 可以从通过率来看 本体用例非常恶心，不过这些异常处理对于合格的程序员来说是必然的吧~ 我还是要不断修炼: )
  
*/

public class Solution {
    public int myAtoi(String str) {
        str = checkNum(str.trim());
        if(str.equals("###False###")) return 0;
        
        boolean neg = false;
        if(str.contains("-")) {
        	str = str.replace("-", "");
        	neg = true;
        }
        long m=1, rev=0;
        for(int i=str.length()-1; i>=0; i--) {
        	String char_i = str.charAt(i) + "";
            rev += Integer.parseInt(char_i) * m;
            if(neg == false && rev > Integer.MAX_VALUE) 
            	return Integer.MAX_VALUE;
            else if(neg == true && -1 * rev < Integer.MIN_VALUE) 
            	return Integer.MIN_VALUE;
            m *= 10;
        }
        
        if(neg == true) return (-1 * (int)rev);
        else return (int)rev;
    }
    private String checkNum(String str) {
    String falseString = "###False###";
    	String checkString = "0123456789+-";
    	if(str.length() == 0) return falseString;
    	if(str.contains("+")) {
    		if(str.length() == 1) return falseString;
    		if(str.contains("-")) return falseString;
    		if(str.indexOf("+") != str.lastIndexOf("+")) return falseString; //two +
    		str = str.replace("+", "");
    	}
    	if(str.contains("-")) {
    		if(str.length() == 1) return falseString;
    		if(str.indexOf("-") != str.lastIndexOf("-")) return falseString; //two -
    	}
    	for(int i=0; i<str.length(); i++) {
    		if(checkString.indexOf(str.charAt(i)) < 0) { //excepted numbers
    			if(str.charAt(i) == '+' && i == 1) return falseString;
    			if(str.charAt(i) == '-' && i == 1) return falseString;
    			str = str.substring(0, i);
    		}
    	}
    	return str;
    }
}
