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
    public ListNode reverseList(ListNode head) {

        // prev will become the new head at the end
        ListNode prev = null;

        // curr is used to traverse the list
        ListNode curr = head;

        // Loop until we reach the end of the list
        while (curr != null) {

            // Step 1: Save next node
            // We must save it before breaking the link
            ListNode next = curr.next;

            // Step 2: Reverse the link
            // Current node now points to previous node
            curr.next = prev;

            // Step 3: Move prev forward
            // prev now becomes current node
            prev = curr;

            // Step 4: Move curr forward
            // Continue traversal using saved next
            curr = next;
        }

        // prev is the new head of reversed list
        return prev;
    }
}
