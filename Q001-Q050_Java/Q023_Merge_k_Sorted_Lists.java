/*
    Definition for singly-linked list.
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    
    合并K个有序链表，是Q021的扩展版。我利用了Q21的函数，对其进行了扩展。
    把合并K个链表分解为合并2个链表的基本问题，设合并2个有序链表的复杂度为M,则
    O(M)方法：拿出第一个有序链表L0，让L和剩下所有的有序链表L1, L2, ..., Li 合并，这种方法简单暴力但最后TLE超时，过不了...
    O(logM)方法：用2分的方法把第一个和最后一个合并，第二个和倒数第二个合并...
	以此类推，直到还剩下一个链表时就是最终结果，结果Accepted, 具体实现见代码。
	
*/

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int N = lists.length;
        while(N != 1) { // merge until the length is 1
        	for(int j=0; j<N/2; j++) {
                lists[j] = mergeTwoLists(lists[j], lists[N-j-1]);
            }
        	//narrow down the N (length)
            if(N%2 == 0) // for even number    
                N=N/2;
            else // for odd number
                N=N/2+1;
        }
        return lists[0];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, l3;
        if(l1 == null) return l2;
        else if(l2 == null) return l1;

        if(l1.val < l2.val) {
        	l3 = l1;
        	l1 = l1.next;
        }
        else {
        	l3 = l2;
        	l2 = l2.next;
        }
    	head = l3;

        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
            	l3.next = l1;
            	l1 = l1.next;
            	l3 = l3.next;
            }
            else {
            	l3.next = l2;
            	l2 = l2.next;
            	l3 = l3.next;
            }
        }
        if(l1 != null) l3.next = l1;
        else if(l2 != null) l3.next = l2;
        else l3.next = null;
        
        return head;
    }
}
