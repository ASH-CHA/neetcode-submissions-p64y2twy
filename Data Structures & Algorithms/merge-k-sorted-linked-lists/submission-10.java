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
        if(lists.length == 0) return null;

        int step = 1;
        while(step < lists.length){
            for(int i = 0; i < lists.length - step; i += step * 2){
                lists[i] = merge2Lists(lists[i], lists[i + step]);
            }
            step *= 2;
        }
        return lists[0];
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                prev.next = head1;
                head1 = head1.next;
            }
            else{
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }

        if(head1 != null) prev.next = head1;
        else prev.next = head2;

        return dummy.next;
    }
}