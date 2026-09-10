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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode adv = head.next;
        ListNode prev = head.next;
        while(curr.next != null && adv.next != null){
            curr.next = adv.next;
            curr = curr.next;
            // curr.next = prev;
            adv.next = curr.next;
            adv = adv.next;
        }
        curr.next = prev;
        return head;
    }
}