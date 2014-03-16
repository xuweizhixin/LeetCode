package leetcode;

import leetcode.SortList.ListNode;

public class Insertion_Sort_List 
{
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	    	  val = x;
	          next = null;
	      }
	 }
	
	public ListNode insertionSortList(ListNode head) 
    {
		if(head ==null || head.next==null) return head;
		
        ListNode p = head.next;
        ListNode q = head;
        ListNode k = head;//compare from the beginning.
        while(p!=null)
        {
        	
        	if(p.val>=q.val)
        	{
        		p = p.next;
        		q = q.next;
        	}
        	else
        	{
        		ListNode temp = p;
        		q.next = p.next;
        		p = p.next;
        		if(temp.val<k.val)
        		{
        			temp.next = head;
        			head = temp;
        			k = head;
        		}
        		else
        		{
        			while(temp.val>k.next.val)
        			{
        				k = k.next;
        			}
        			temp.next = k.next;
        			k.next = temp;
        			k = head;
        		}
        	}
        	
        }
        return head;
        
    }
	
	public static void main(String[] args)
	{
		ListNode test = new ListNode(4);
		ListNode one = new ListNode(3);
		test.next = one;
		ListNode two = new ListNode(1);
		one.next = two;
		ListNode three = new ListNode(4);
		two.next = three;
		
		for(ListNode p = new Insertion_Sort_List().insertionSortList(test) ; p!=null;p = p.next)
		{
			System.out.print(p.val+" ");
		}
		
		
	}
}
