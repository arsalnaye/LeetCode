class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode lesserHead = new ListNode(-1);
        ListNode lesserTail = lesserHead;

        ListNode greaterHead = new ListNode(-1);
        ListNode greaterTail = greaterHead;

        ListNode temp = head;

        while (temp != null) {

            if (temp.val < x) {

                // Separate this node
                ListNode insertNode = temp;
                temp = temp.next;
                insertNode.next = null;

                // Insert at tail of lesser list
                lesserTail.next = insertNode;
                lesserTail = insertNode;

            } else {

                // Separate this node
                ListNode insertNode = temp;
                temp = temp.next;
                insertNode.next = null;

                // Insert at tail of greater list
                greaterTail.next = insertNode;
                greaterTail = insertNode;
            }
        }

        // Join both lists
        lesserTail.next = greaterHead.next;

        // Remove dummy node
        return lesserHead.next;
    }
}