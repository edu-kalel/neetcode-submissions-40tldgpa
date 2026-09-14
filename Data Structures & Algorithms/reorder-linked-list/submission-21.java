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
        ListNode fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }


        // reverse
        // {
        ListNode current = slow.next;
        ListNode prev = null;
        while(current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        ListNode l2 = prev;
        slow.next = null;
        // now l2 should be head of l2
        // }
        // System.out.println(l2.val);
        // merge
        // prev and head

        ListNode helper = head;
        while(l2!=null){
            ListNode temp = helper.next;
            helper.next = l2;
            helper=temp;
            ListNode temp2 = l2.next;
            l2.next = helper;
            l2 = temp2;
        }



        // [1, 2, 3, 4]
        // [9, 8, 7, 6, 5]
        // ListNode temp1 = l1.next;
        // ListNode temp2 = l2.next;
        
    }
}
