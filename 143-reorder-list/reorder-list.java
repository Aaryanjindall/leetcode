class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev2 = null;
        ListNode agla = null;
        while(curr != null){
            agla = curr.next;
            curr.next = prev2;
            prev2 = curr;
            curr = agla;
        }
        ListNode left = head;
        while(prev2 != null){
            ListNode templ = left.next;
            ListNode tempr = prev2.next;
            left.next = prev2;
            prev2.next = templ;
            left = templ;
            prev2 = tempr;
        }
    }
}