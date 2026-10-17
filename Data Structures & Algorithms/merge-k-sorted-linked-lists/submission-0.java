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
        if(lists == null) {
            return null;
        }
        if(lists.length == 0) {
            return null;
        }
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        if(minHeap.size() == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            if(min.next != null) {
                minHeap.add(min.next);
            }
            if(head == null) {
                head = min;
            } else {
                tail.next = min;
            }
            tail = min;
        }
        return head;
    }
}
