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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans=new ListNode[k];
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }int baseSize=(len/k);
        int extraNodes=(len%k);
        //main logic
        ListNode prev=null;
        ListNode curr=head;
        for(int part=0;part<k;part++){
            if(curr==null){
                ans[part]=curr;
                continue;
            }//insert curr into array
            ans[part]=curr;
            //find width of current sub lsit
            int width=baseSize+(extraNodes>0? 1:0);
            extraNodes--;
            for(int i=1;i<=width;i++){
                prev=curr;
                curr=curr.next;
            }prev.next=null;
            //move to next iterator
            prev=null;
        }return ans;
    }
}