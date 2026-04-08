/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)
            return null;
        if(head.next.next==null && n==2)
            return head.next;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        ListNode prev = head;
        while(n>0){
            ptr1 = ptr1.next;
            n--;
        }
        while(ptr1!=null){
            ptr1 = ptr1.next;
            prev = ptr2;
            ptr2 = ptr2.next;
        }
        if(ptr2==head){
            head = head.next; 
        }
        prev.next=ptr2.next;
        return head;   
    }
}
