
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Calculate the length
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Step 2: Find the node before the target
        int d = len - n;
        ListNode prev = dummy;

        for (int i = 0; i < d; i++) {
            prev = prev.next;
        }

        // Step 3: Remove the target node
        prev.next = prev.next.next;

        return dummy.next;
    }
}
