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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        k = k % size;
        if(k == 0) return head;

        //splitting occur at size - k + 1 from the first;
        ListNode curr = head;
        ListNode prev = null;
        for(int i = 0; i < size - k; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;

        ListNode temp1 = curr;
        while(temp1.next != null){
            temp1 = temp1.next;
        }

        temp1.next = head;
        head = curr;

        return head;

    }
}