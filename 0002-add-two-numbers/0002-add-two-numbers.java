
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        int carry = 0;
        while(temp1 != null && temp2 !=null){
            ListNode newNode = new ListNode((temp1.val + temp2.val + carry)%10);
            ans.next = newNode;
            carry = (temp1.val + temp2.val + carry)/10;
            ans = ans.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        } 
        while(temp1 != null){
            ListNode newNode1 = new ListNode((temp1.val + carry)%10);
            carry = (temp1.val + carry)/10;
            ans.next = newNode1;
            ans = ans.next;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            ListNode newNode2 = new ListNode((temp2.val + carry)%10);
            carry = (temp2.val + carry)/10;
            ans.next = newNode2;
            ans = ans.next;
            temp2 = temp2.next;
        }
        if (carry > 0) {
            ans.next = new ListNode(carry);
        }

        return res.next;
    }
}