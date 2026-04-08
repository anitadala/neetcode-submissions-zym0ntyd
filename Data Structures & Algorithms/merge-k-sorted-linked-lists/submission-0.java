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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode list: lists){
            if(list!=null){
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){

            ListNode front = pq.poll();
            tail.next = front;
            tail = tail.next;

            if(front.next!=null){
                pq.offer(front.next);
            }
        }
        return dummy.next;

    }

}
