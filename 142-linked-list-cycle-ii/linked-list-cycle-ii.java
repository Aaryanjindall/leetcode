public class Solution {
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode pt = head;
                while(pt != slow){
                    slow = slow.next;
                    pt = pt.next;
                }
                return pt;
            }
        }
        return null;
    }
}