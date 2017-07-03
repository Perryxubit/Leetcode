/*
    这道题很有意思，合并区间，需要注意的是[1,2]和[3,4]是无法合并的(不连续)。
    绝大部分的解法是对每个区间的头排序，然后再一一合并。
    
    而我有一种不用合并的解法可以完美匹配这道题 - 用Hash数组, 我AC的程序性能极高，打败了96%的Java submissions.
    假设我们给2个区间[1,2]和[4,6], 于是我们可以在hash数组hash[]中将区间包含的元素和区间不包含的元素分开标记为1和0.
    例如给定刚才的两个区间，则hash[0]到hash[6]为 {0 1 1 0 1 1 1}。
    我们把所有区间end的最大值作为hash的长度len，再经过标记处理后，从0遍历到len找到最后连续的区间即可！

	但是！！！...还有很多要处理的地方，比如[1,2]和[3,4]如果只是简单的标记在hash数组中，
	那么结果是{0 1 1 1 1}, 在合并完的遍历过程中，会把区间[1,2]和[3,4]合并为[1,4]..
	*因此，我把每个区间的结尾元素用2来标记到hash数组中, 所以[1,2]和[3,4]合并的情况在hash数组中变为
	{0 1 2 1 2}, 这就可以用2来区分开2个区间了，同理，在最后检查区间时，遍历到2即表示当前区间结束了。
	还要注意，2的优先级是低于1的，例如：如果是区间[1,3]和[2,4]的话，则hash结果为{0 1 1 1 2}, 
	可以看到，第一个区间中的结尾位置3的2被第二个区间的1所覆盖，这样才能保证交叉区间的连续性！

	这就结束了吗?不...还有一种情况: 当start=end的情况, 如[1,1]。
	这种情况hash[1]不能存1，要保存2，这样就可以完美的匹配所有情况。

	总结: 用0 1 2 来标记元素，优先级: 1 > 2 > 0

	PS:我已经将这个解法post到leetcode的discuss中，欢迎点赞留言！
	https://discuss.leetcode.com/topic/94607/defeat-95-java-ac-new-hash-solution-no-sort

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
