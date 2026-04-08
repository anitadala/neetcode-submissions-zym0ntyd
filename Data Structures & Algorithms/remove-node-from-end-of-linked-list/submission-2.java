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
        int total_len = 0;
        ListNode ptr = head;
        while(ptr!=null){
            total_len++;
            ptr = ptr.next;
        }
        int target_node = total_len - n ;
        ptr = head;
        ListNode prev = null;
        int cnt = 0;
        while(cnt!=target_node){
            cnt++;
            prev = ptr;
            ptr = ptr.next; 
        }
        if(cnt==0 ) 
            return head.next;
        prev.next = ptr.next;
        return head;
    }
}
