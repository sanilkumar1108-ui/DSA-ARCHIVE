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
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(n == size){
            head = head.next;
            return head;
        }

        // int target = size - n + 1;//target from the front 
        ListNode prev = head;
        for(int i = 1; i < size -n; i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}