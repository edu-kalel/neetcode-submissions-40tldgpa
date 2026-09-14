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
        // check if empty or null
        if(lists == null || lists.length == 0){
            return null;
        }
        
        return divide(lists, 0, lists.length-1);
    }

    public ListNode divide(ListNode[] lists, int l, int r){
        if(l>r){
            return null;
        }
        if(l==r){
            return lists[l]; //only one list to return, already sorted
        }
        int mid = (r-l)/2 + l;
        
        ListNode left = divide(lists , l, mid);
        ListNode right = divide(lists , mid+1 , r);

        return conquer(left, right);
    }

    // [ 1 , 2 , 3 , 4 , 6]
    // [ 2 , 3, 4]
    public ListNode conquer(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode helper = dummy;

        while(left!= null && right!=null){
            if(left.val<right.val){
                helper.next = left;
                left = left.next;
            }
            else{
                helper.next = right;
                right = right.next;
            }
            helper = helper.next;
        }

        if(left == null){
            helper.next = right;
        }
        else{
            helper.next = left;
        }

        return dummy.next;
    }
}
