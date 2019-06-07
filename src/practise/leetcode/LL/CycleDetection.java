package practise.leetcode.LL;

import java.util.HashSet;
import java.util.Set;

//Leetcode 141 & 142
public class CycleDetection {
	//Slow fast pointer approach
	public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
		ListNode slow,fast;
		slow=head;
		//Placing the fast pointer at this point works only for cycle detection  & not for finding cycle start point.
        fast=head.next.next;
		while(fast!=null && fast.next!=null && fast!=slow){
			slow=slow.next;
			fast=fast.next.next;
		}
		
		if(fast!=null && fast==slow)
			return true;
		return false;		
    }
	
	//HashSet approach.
	public boolean hasCycleUsingSet(ListNode head) {
        Set<ListNode> isVisited =new HashSet<ListNode>();        
        while(head!=null){
        	if(!isVisited.contains(head)){
        		isVisited.add(head);
        		head=head.next;
        		continue;
        	}
        	return true;
        }
        return false;
    }
	
	//Using Set approach
	public ListNode detectCycle(ListNode head){
		Set<ListNode> isVisited =new HashSet<ListNode>();        
        while(head!=null){
        	if(!isVisited.contains(head)){
        		isVisited.add(head);
        		head=head.next;
        		continue;
        	}
        	return head;
        }
        return null;
	}
	
	//Using slow & fast pointer approach.
	public ListNode detectCycleSlowFast(ListNode head){
		if(head==null || head.next==null)
            return null;
		ListNode slow,fast;
		slow=head;
        fast=head;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
            if(fast==slow)
                break;
		}
        
		if(fast!=null && fast==slow){
            slow=head;
			while(fast!=slow){
				fast=fast.next;
				slow=slow.next;
			}
			return fast;
		}
		return null;
	}
}