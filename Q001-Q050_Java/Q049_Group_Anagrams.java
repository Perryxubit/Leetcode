/*
    本题把相同字母组成的字符串放在一起，
    把每个字符串排序好然后哈希即可.. 非常简单的题..
    哈希映射： {排序后的字符串 -> 该字符串序列对应的结果集}
    
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		ArrayList<List<String>> rev = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new  HashMap<String, ArrayList<String>>();
		for(int i=0; i<strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String mapstr = String.valueOf(temp);
			if(map.get(mapstr) == null) { // new group遍历hashmap
				ArrayList<String> newlist = new ArrayList<String>();
				newlist.add(strs[i]);
				map.put(mapstr, newlist);
			}
			else { //old group
				ArrayList<String> templist = map.get(mapstr);
				templist.add(strs[i]);
			}
		}
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next().toString();
			rev.add(map.get(key));
		}
        return rev;
    }
}
