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
    public void reorderList(ListNode head) {
        // find the middle using fast and slow
        // reverse second half
        // merge, one l1, one l2
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse
        // {
        ListNode helper = null;
        ListNode l2 = slow.next;
        // ListNode temp = l2.next;
        while(l2!=null){
            ListNode temp = l2.next;
            l2.next = helper;
            helper = l2;
            l2 = temp;
            // temp = l2.next;
        }
        l2 = helper;
        slow.next = null;
        // now l2 should be head of l2
        // }
        // System.out.println(l2.val);
        // merge
        // {
        ListNode l1 = head;
        // ListNode temp1 = l1.next;
        // ListNode temp2 = l2.next;
        while(l2!=null ){
            ListNode temp1 = l1.next;
            l1.next = l2;
            l1 = temp1;
            ListNode temp2 = l2.next;
            l2.next = l1;
            l2 = temp2;
        }
        // }
        
    }
}
