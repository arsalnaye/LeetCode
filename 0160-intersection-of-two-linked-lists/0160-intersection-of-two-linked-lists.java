/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }ListNode a=headA;
        ListNode b=headB;
        while(a!=null && b!=null){
            a=a.next;
            b=b.next;
        }if(a==null){
            //either b list length is greater or equal
            int bextralen=0;
            while(b!=null){
                bextralen++;
                b=b.next;
            }while(bextralen-->0){
                headB=headB.next;
            }
        }else{
            //b=null
            //a list length greater than or equal to b
            int aextralen=0;
            while(a!=null){
                aextralen++;
                a=a.next;
            }while(aextralen-->0){
                headA=headA.next;
            }
        }//now headA and headB are arranged so that when they move forward
        //they will ENCOUNTER same number of nodes
        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }else{
                headA=headA.next;
                headB=headB.next;
            }
        }//common node not found
        return null;
    }
}