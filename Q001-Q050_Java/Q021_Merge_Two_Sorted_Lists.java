/*
    Definition for singly-linked list.
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    
    合并2个有序链表，是个非常基础的题，不解释了.. 详见代码。
    写了2种方法，mergeTwoLists1是使用额外空间(不改变l1和l2结构)的方法, mergeTwoLists2是不用额外空间(需要改变l1和l2结构)。
    第二个方法更简洁一些。
    
*/

public class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode l3 = null, pre = null, head = null;
        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val) { // put node of l1 (smaller one) into l3
                l3 = new ListNode(l1.val);
                l3.next = null;
                if(head == null) head = l3;
                if(pre != null)
                    pre.next = l3;
                pre = l3;
                l1 = l1.next;
            }
            else { //put node of l2 (bigger one) into l3
                l3 = new ListNode(l2.val);
                l3.next = null;
                if(head == null) head = l3;
                if(pre != null)
                    pre.next = l3;
                pre = l3;
                l2 = l2.next;
            }
        }
        while(l1!=null) {
            l3 = new ListNode(l1.val);
            l3.next = null;
            if(head == null) head = l3;
            if(pre != null)
                pre.next = l3;
            pre = l3;
            l1 = l1.next;
        }
        while(l2!=null) {
            l3 = new ListNode(l2.val);
            l3.next = null;
            if(head == null) head = l3;
            if(pre != null)
                pre.next = l3;
            pre = l3;
            l2 = l2.next;
        }
        return head;
    }
    
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
