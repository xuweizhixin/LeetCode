package leetcode;

//  Definition for singly-linked list.

public class SortList 
{
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	    	  val = x;
	          next = null;
	      }
	 }
	
	public ListNode sortList(ListNode head) 
    {
		if(head == null||head.next == null) return head;
        int n =0; // n is the number of nodes in the list.
        for(ListNode p = head; p!= null; p = p.next)
        {
        	n++;
        }
        int cut = n/2-1;
        
        ListNode p = head;
        for(int i = 0; i <cut; i++)
        {
        	p = p.next;
        }
        ListNode q=p.next;
        p.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(q);
        ListNode res = merge(first, second);
        
        return res;
    }

	private ListNode merge(ListNode p, ListNode q) 
	{
		ListNode res;
		if(p.val>q.val) res = q;
		else res = p;
		ListNode hp = new ListNode(-99999);
		ListNode hq = new ListNode(-99999);
		hp.next = p;
		hq.next = q;
		ListNode temp;
		
		while(p!=null&&q!=null)
		{
			if(p.val<=q.val)
			{
				while(p.next!=null&&p.next.val<q.val)
				{
					p = p.next;
					hp = hp.next;
				}
				hq.next = q.next;
				temp = q.next;
				q.next = p.next;
				p.next = q;
				hp = p;
				p = q;
				q = temp;
				
			}
			else
			{
				hq.next = q.next;
				temp = q.next;
				hp.next = q;
				q.next = p;
				hp = q;
				q=temp;
			}
		}
		return res;
		
	}
	
	public static void main(String[] args)
	{
		ListNode test = new ListNode(1);
		ListNode one = new ListNode(2);
		test.next = one;
		ListNode two = new ListNode(3);
		one.next = two;
		ListNode three = new ListNode(4);
		two.next = three;
		
		for(ListNode p = new SortList().sortList(test) ; p!=null;p = p.next)
		{
			System.out.print(p.val+" ");
		}
		
		
	}
}
