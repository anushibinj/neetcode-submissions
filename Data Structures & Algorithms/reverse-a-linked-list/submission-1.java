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
// [0, 1, 2, 3]
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            // save
            ListNode temp = curr.next;
            // flip
            curr.next = prev;
            // move
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
