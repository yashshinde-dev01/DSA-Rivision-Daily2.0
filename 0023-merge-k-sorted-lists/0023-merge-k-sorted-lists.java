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
        ArrayList<Integer>lst=new ArrayList<>();

        for(ListNode head:lists){
            while(head!=null){
                lst.add(head.val);
                head=head.next;
            }
        }
        Collections.sort(lst);
        
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;

        for(int nums:lst){
            temp.next=new ListNode(nums);
            temp=temp.next;
        }
        return dummy.next ;
    }
}