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
        if(lists==null || lists.length == 0){
            return null;
        }

        return divide(lists, 0, lists.length-1);
    }

    ListNode divide(ListNode[] lists, int l, int r){
        if(l>r){
            return null;
        }
        if(l==r){
            return lists[l];
        }
        int mid = (l+r)/2;

        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid+1, r);

        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode helper = dummy;

        while(left!=null && right!= null){
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

        if(left==null){
            helper.next = right;
        }
        else{
            helper.next = left;
        }

        return dummy.next;
    }
}






