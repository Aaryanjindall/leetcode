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
        if(head == null){
            return null;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            return head.next;
        }
        int idx = size-n;
        ListNode cur = head;
        for(int i = 0 ; i < idx-1 ; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }
}