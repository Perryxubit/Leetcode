/*
    本题要求实现高精度乘法... 
    说实话 高精度计算都是基础问题，只要模拟人类计算的思维就可以了。
    把输入反过来，依次相乘进位..最后把每一位的乘机结果都加起来，再用高精度加法来进位，即可得到结果。
    我这个程序比较长，性能一般，但是可以A掉，当基础题来做吧。

*/

public class Solution {
    public String multiply(String num1, String num2) {
		StringBuilder str1 = new StringBuilder(num1);
		StringBuilder str2 = new StringBuilder(num2);
        
		//1. reverse Strings
		for(int i=0; i<=str1.length()/2-1; i++) {
			char ch = str1.charAt(str1.length()-1-i);
			str1.setCharAt(str1.length()-1-i, str1.charAt(i));
			str1.setCharAt(i, ch);
		}
		for(int i=0; i<=str2.length()/2-1; i++) {
			char ch = str2.charAt(str2.length()-1-i);
			str2.setCharAt(str2.length()-1-i, str2.charAt(i));
			str2.setCharAt(i, ch);
		}
//		System.out.println(str1 + "  " + str2);
		
		//2. make sure the str2 is the long one
		if(str2.length() < str1.length()) { 
			StringBuilder temp = new StringBuilder();
			temp = str2;
			str2 = str1;
			str1 = temp;
		}
		
		//3. multiply
		char[][] Multiply = new char[str1.length()][str1.length()+str2.length()];
		for(int i=0; i<str1.length(); i++) {
			int MulNum1 = Integer.parseInt(str1.charAt(i)+"");
			int carry = 0, multiply_index = i;
			for(int j=0; j<str2.length(); j++) {
				int MulNum2 = Integer.parseInt(str2.charAt(j)+"");
				int curPos = (MulNum1 * MulNum2)%10 + carry;
				carry = 0; // clear the carry
				if(curPos >= 10) {
					carry += curPos/10;
					curPos = curPos%10;
				}
				carry += (MulNum1 * MulNum2)/10;
				//put curpos in multiply
				Multiply[i][multiply_index++] = (curPos + "").charAt(0);
			}
			if(carry != 0) Multiply[i][multiply_index++] = (carry + "").charAt(0);
		}
//		for(int i=0; i<str1.length(); i++) {
//			for(int j=0; j<str1.length()+str2.length(); j++)
//				System.out.print(Multiply[i][j] + " ");
//			System.out.println();
//		}

		//4. merge the Multiply[][] array
		char[] product = new char[str1.length()+str2.length()+1];
		int product_index = 0, carry = 0, curNum = 0;
		for(int j=0; j<str1.length()+str2.length(); j++) {
			curNum = carry;
			for(int i=0; i<str1.length(); i++) {
				if(Multiply[i][j] == 0) continue;
				curNum += Integer.parseInt(Multiply[i][j]+"");
			}
			product[product_index++] = (curNum%10 + "").charAt(0);
			carry = curNum/10;
		}
		if(carry != 0) product[product_index] = (carry + "").charAt(0);
		String result = new String(product);
		if(carry == 0) result = result.substring(0, result.length()-1);
//		System.out.println(result);
		
		//5. reverse the result again!
		StringBuilder productStr = new StringBuilder(result);
		for(int i=0; i<=productStr.length()/2-1; i++) {
			char ch = productStr.charAt(productStr.length()-1-i);
			productStr.setCharAt(productStr.length()-1-i, productStr.charAt(i));
			productStr.setCharAt(i, ch);
		}
		
		//6. remove the leading zero - 0
		result = new String(productStr);
		int firstIndex = 0;
		for(firstIndex=0; firstIndex<result.length(); firstIndex++)
			if(result.charAt(firstIndex) != '0') break;
		result = result.substring(firstIndex);		
		if(result.length() == 0) result = "0";
		
		return result;
    }
}
