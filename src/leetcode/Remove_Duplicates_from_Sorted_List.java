package leetcode;

public class Remove_Duplicates_from_Sorted_List 
{
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	public static void main(String[] args)
	{
		
	}
	public static ListNode deleteDuplicates (ListNode head) 
	{
		ListNode res = head;
        for(ListNode p = res; p != null; p = p.next)
        {
        	if(p.next == null) break;
        	if(p.next == p)
        	{
        		p.next = p.next.next;
        	}
        }
        return res;
    }
}
