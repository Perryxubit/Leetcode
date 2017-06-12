/*
    Definition for singly-linked list.
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    
    题意：删除单链表倒数第N个节点。
    O(N)方法1：
    题目要求遍历一边得出结果，我的方法是建立一个数组R，数组中每个元素都是对链表中每个节点的引用，把倒着数问题转化为正着数问题。
    这样遍历一遍下来链表的长度L就可以得到了。
    在头结点之前我加入了preHead节点(值随意，我设置为-1，对于链表处理来说还是养成从第二个节点开始处理比较好:D)，
	防止输入只有一个节点还被删除的情况下程序无效引用。
    
	对于输入{1 2 3 4 5}来说，我建立数组分别引用-1 1 2 3 4 5 这6个元素，则倒数第N个数也就是正着数的第L-N+1个数。
    (由于数组下标为0，所以这个数也就是数组中的R[L-N]所引用的节点)。
    所以我们直接把R[L-N]的节点删除即可。
    O(N)方法2: 
    我还用递归做了一遍，也是只遍历一遍，但是好像TLE了。。还没具体查可能哪里有bug，以后有时间再继续~ (详见removeNthFromEnd2方法)
    O(N)方法3:
    网上还有用快慢指针的方法，这种方法更巧妙一些，也是遍历一遍完成删除，具体方法为：
    设置快指针F和慢指针S，先让快指针F遍历链表中的N个元素，然后让F和S同时移动，直到F指向了链表尾(next为null)。
    此时，F和S相差了N个位置，我们直接删除S指向的节点即可。这种方法我还没空写，不过实现起来也不难。
    
*/

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) return null;
		ArrayList<ListNode> reference = new ArrayList<>();
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		for(ListNode p=preHead; p!=null; p=p.next) {
			ListNode node = p;
			reference.add(node);
		}
		if(reference.size() < n) return head;
		int delete_index = reference.size()-n;
		reference.get(delete_index-1).next = reference.get(delete_index-1).next.next;
		if(preHead.next != null) return preHead.next;
		else return preHead;
    }
    
    public ListNode removeNthFromEnd2(ListNode head, int n) {
		if(head.next == null && n == 1) return null;
		ListNode preHead = new ListNode(-1);
		preHead.next = head;
		ListRecursion(preHead, n);
		if(preHead.next != null) return preHead.next;
		else return preHead;     
    }
    
	public int ListRecursion(ListNode node, int n) {
		if(node.next == null)
			return 0;
		int next_n = 1+ListRecursion(node.next, n);
		if(next_n == 0) return -1;
		else if(next_n == n) {
			node.next = node.next.next;
			System.out.println(node.val);
			return -1;
		}
		else return 1+ListRecursion(node.next, n);
	}
}
