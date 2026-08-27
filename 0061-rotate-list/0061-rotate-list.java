class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Empty list / single node / no rotation
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and last node
        int len = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            len++;
        }

        // If k is greater than length
        k = k % len;

        // No rotation needed
        if (k == 0) {
            return head;
        }

        // Make the list circular
        temp.next = head;

        // Find the new tail
        // New tail is at position len - k
        temp = head;

        for (int i = 1; i < len - k; i++) {
            temp = temp.next;
        }

        // New head
        ListNode fwd = temp.next;

        // Break the circle
        temp.next = null;

        return fwd;
    }
}