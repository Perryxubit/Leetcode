/*
    还是高精度加法的延伸(参考Q002, Q066), 对2进制的数进行高精度加。
    具体直接看代码吧，非常简单的题。

*/

public class Solution {
    public String addBinary(String a, String b) {
        int maxlen = a.length()>b.length()? a.length():b.length();
        int minlen = a.length()>b.length()? b.length():a.length();
		int[] sum = new int[maxlen+1];
        int carry = 0;
        
        int i = 0;
		while(i < minlen) { // add common parts
			char ac = a.charAt(a.length()-1-i);
			char bc = b.charAt(b.length()-1-i);
			int c = Integer.parseInt(ac+"") + Integer.parseInt(bc+"") + carry;
			carry = c/2;
			sum[i] = c%2;
			i++;
		}
		
		while(i < maxlen) { // add other parts
			if(maxlen == a.length()) { // add a
				char ac = a.charAt(a.length()-1-i);
				int c = Integer.parseInt(ac+"") + carry;
				carry = c/2;
				sum[i] = c%2;
				i++;
			}
			else { // add b
				char bc = b.charAt(b.length()-1-i);
				int c = Integer.parseInt(bc+"") + carry;
				carry = c/2;
				sum[i] = c%2;
				i++;
			}
		}
		
		String res = "";
		if(carry != 0) { // still have carry
			sum[i] = 1;
			for(int j=sum.length-1; j>=0; j--)
				res += sum[j] + "";
		}
		else {
			for(int j=sum.length-2; j>=0; j--)
				res += sum[j] + "";
		}

		return res.trim();
    }
}
