/**
	  Definition for singly-linked list.
	  public class ListNode {
      	int val;
     	ListNode next;
      	ListNode(int x) { val = x; }
	  }
  
  	本题用链表实现2个非负数相加，本质是链表实现的高精度加法...
  	代码实现如下，需要注意：两个输入链表的长度可能不能，所以在逐位相加之后，要将剩余的输入链表连入结果
  	同时还需要注意的是各种情况下相加进位的情况，本程序用flag来标记是否进位。
  
 */
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = null, prenode = null, newnode = null;
        for(int i=0; l1!=null && l2!=null ;i++) { //if anyone is null, then exit
            int value = l1.val + l2.val + flag;
            if(value/10 != 0) { //adding a carry number to next position
                flag = value/10;
                value = value%10;
            }
            else flag = 0; // not adding new carry number to next position
            
            //new node:
            newnode = new ListNode(value);
            newnode.next = null;
            if(prenode == null) { //first node
                prenode = newnode;
                head = newnode; // set head
            }
            else {
                prenode.next = newnode;
                prenode = prenode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // still have more nodes for l1 and l2
        if(l1 != null) {
            prenode.next = l1;
            while(l1 != null) {
                l1.val = l1.val + flag;
                flag = l1.val/10;
                l1.val = l1.val%10;
                prenode = l1;
                l1 = l1.next;
            }
        }
        if(l2 != null) {
            prenode.next = l2;
            while(l2 != null) {
                l2.val = l2.val + flag;
                flag = l2.val/10;
                l2.val = l2.val%10;
                prenode = l2;
                l2 = l2.next;
            }
        }
        if(flag != 0) { // still have new one carry number to add
            newnode = new ListNode(flag);
            newnode.next = null;
            prenode.next = newnode;
        }
        return head;
    }
}
