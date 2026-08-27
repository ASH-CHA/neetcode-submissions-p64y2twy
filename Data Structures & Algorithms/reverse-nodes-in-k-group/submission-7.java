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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while(ptr != null){
            ListNode track = ptr;

            for(int i = 0; i < k; i++){
                if(track == null) break;
                track = track.next;
            }

            if(track == null) break;

            ListNode[] reversedList = reverseList(ptr.next, k);

            ListNode prev = reversedList[0];
            ListNode curr = reversedList[1];

            ListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = curr;
            ptr.next = prev;
            ptr = lastNodeOfReversedGroup;
        }
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, int k){
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        for(int i = 0; i < k; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{prev, curr};
    }
}