/*
    Definition for singly-linked list.
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    
    对链表中的数进行成对交换，难度Medium里最简单的题? (题目要求必须交换ListNode节点，单纯交换val数字的同学不要想偷懒...)
    对链表两两遍历就好.. 并用p0记录当前两个节点的前一个节点就可以执行节点交换了，如果链表含有奇数个节点则最后一个节点不用管。
      
*/

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p1, p2, p0=null;
    	if(head == null || head.next == null) return head;
    	p1 = head;
    	p2 = head.next;
    		
    	while(p1!=null && p2!=null) {
    		if(p1==head) {
    			p1.next = p2.next;
    			p2.next = p1;
    			//move head
    			head = p2;			
    		}
    		else {
    			p0.next = p2;
    			p1.next = p2.next;
    			p2.next = p1;
    		}
    		//move pointer
    		p0=p1;
    		p1 = p1.next;
    		if(p1!=null) p2 = p1.next;
    	}
        return head;
    }
}
