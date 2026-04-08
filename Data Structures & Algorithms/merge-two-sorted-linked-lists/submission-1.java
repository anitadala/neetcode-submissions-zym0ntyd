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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode head1 = head;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val)
            {
                head1.next = list1;    
                list1 = list1.next;
            }
            else {
                head1.next = list2;
                list2 = list2.next;
            }
            head1 = head1.next;
        }
        if(list1==null)
            head1.next = list2;
        else if(list2==null)
            head1.next = list1;
        return head.next;
    }
}
// [1,2,  3,  6]    [  4,  5]
//        h.  p1       p2