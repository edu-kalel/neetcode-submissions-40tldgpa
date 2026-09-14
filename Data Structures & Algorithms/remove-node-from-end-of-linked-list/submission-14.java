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
        ListNode dummy = new ListNode(0, head);
        ListNode h1 = dummy;
        ListNode h2 = head;

        for(int i = 0 ; i < n ; i++){
            h2 = h2.next;
        }

        while(h2!=null){
            h1 = h1.next;
            h2 = h2.next;
        }

        h1.next = h1.next.next;

        return dummy.next;
    }
}
