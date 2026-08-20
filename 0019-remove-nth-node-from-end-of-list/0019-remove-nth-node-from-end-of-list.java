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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;

        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        if(len==n)return head.next;
        ListNode temp2=head;
        ListNode prev=head;
        for(int i=0;i<len-n;i++){
            temp2=temp2.next; 
        }
        while(prev.next!=temp2){
            prev=prev.next;
        }
        prev.next=temp2.next;
        return head;
    }
}