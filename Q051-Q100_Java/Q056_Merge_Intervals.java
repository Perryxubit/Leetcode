/*
    这道题很有意思，合并区间，需要注意的是[1,2]和[3,4]是无法合并的(不连续)。
    绝大部分的解法是对每个区间的头排序，然后再一一合并。
    
    而我有一种不用合并的解法可以完美匹配这道题 - 用Hash数组。
    假设我们给2个区间[1,2]和[4,6], 于是我们可以在hash数组hash[]中将区间包含的元素和区间不包含的元素分开标记为1和0.
    例如给定刚才的两个区间，则hash[0]到hash[6]为 {0 1 1 0 1 1 1}。
    我们把所有区间end的最大值作为hash的长度len，再经过标记处理后，从0遍历到len找到最后连续的区间即可！





     Definition for an interval.
     public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
     }

*/

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int MAX = -1;
        for(int i=0; i<intervals.size(); i++) { // get maxmium entry
            if(intervals.get(i).end > MAX) MAX = intervals.get(i).end;
        }
        //using hash array
        int[] hash = new int[MAX+2];
        for(int i=0; i<intervals.size(); i++) {
        	if(intervals.get(i).start == intervals.get(i).end) {
        		if(hash[intervals.get(i).start] == 0) //do not disturb other intervals
        			hash[intervals.get(i).start] = -1;
        	}
        	else {
	            for(int j=intervals.get(i).start; j<intervals.get(i).end; j++) {
	            	//from start to end
	                hash[j] = 1;
	            }
        		//we have to make sure [1,3] [4,6] can not be merged
        		// we have to also make sure this will not end up the previous continuous intervals
        		if(hash[intervals.get(i).end] != 1) 
        			hash[intervals.get(i).end] = 2; //end sign
        	}
        }
        //traverse to get merged section
        List<Interval> result = new ArrayList<Interval>();
        int s = -1;
        for(int i=0; i<=MAX+1; i++) {
        	if(hash[i] == -1) { // self-interval
        		result.add(new Interval(i, i));
        	}
        	else if(hash[i] == 1 && s == -1) { // new interval
        		s = i;
        	}
            else if(hash[i] == 2 && s!=-1) { // interval is end
                result.add(new Interval(s, i));
                s=-1;
            }
        }
        return result;
    }
}
