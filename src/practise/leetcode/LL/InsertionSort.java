package practise.leetcode.LL;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Leetcode 147
public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1),curr=head.next;
        dummy.next=head;
        ListNode lastSorted = head;
        
        while(curr!=null){
            if(curr.val>=lastSorted.val){                
                lastSorted=curr;
                curr=curr.next;
            }
            else{
                ListNode tmp = curr;
                    
                curr=curr.next;
                lastSorted.next=curr;
                
                ListNode prev=dummy,nextN=dummy.next;
                
                while(nextN.val<tmp.val){
                    prev=prev.next;
                    nextN=nextN.next;                    
                }
                
                prev.next=tmp;
                tmp.next=nextN;
            }
        }
        return dummy.next;
    }
}