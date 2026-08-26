class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {

            if (prev.val == curr.val) {
                // duplicate found
                prev.next = curr.next;
                curr = curr.next;
            } else {
                // move both pointers
                prev = prev.next;
                curr = curr.next;
            }
        }

        return head;
    }
}