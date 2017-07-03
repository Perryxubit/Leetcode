/*
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  
  本题要求给定一个链表，把链表右侧的K个元素依次旋转到左侧。
  比如给定 1->2->3->4，K=2时我们得到了3->4->1->2。
  首先我们求出链表长度len，
  1) 如果K < len时，定义新的指针node指向头节点，之后把node指针右移K次，然后把头指针和node指针同时右移直到node指针指向空即可。
  这种巧妙的处理方法类似于Q019(Remove Nth Node From End of List)，需要记住它 :)
  2) 如果K = len时，意思为把整个链表翻转一边，相当于根本没翻转...返回原来的list即可。
  3) 如果K > len时，可以想象一下：
  把 1->2->3->4，翻转6次(K=6)，我们可以得到3->4->1->2，其实就是翻转len次后再翻转2次。
  所以，每翻转len次都会把链表回复原状，可以忽略，翻转K次也就是反转K%len次的结果！
  于是我们把K > len的情况利用k = k%len 转化为了K < len的情况。
  
  此外，再注意一下输入链表为空时的情况即可，实现起来挺简单的，详见我的代码。

*/

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		ListNode node = head, preHead = head, h = head;
		//1. judge the length and k
		int len = 0;
		while(node != null) {
			node = node.next;
			len++;
		}
		node = head;
		if(k >= len && len != 0) { // k == len means all numbers are rotated, and status is the same as initial one
			k = k%len; // get mod to rotate next round
		}
		if(k == 0 || len == 0 || head == null) return head;
		//2. move K step from head
		for(int i=1; i<k; i++) {
			node = node.next;
		}
		//3. move head/tail pointer together
		while(node != null && node.next != null) {
			preHead = head;
			head = head.next;
			node = node.next;
		}
		//4. rotate the list:
		if(node != null) node.next = h;
		if(preHead != null) preHead.next = null;	
        
	    return head;
	}
}
