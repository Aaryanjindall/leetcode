class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        prev.next = null;
        ListNode pichla = null;
        ListNode curr = slow;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = pichla;
            pichla = curr;
            curr = next;
        }
        ListNode left = head;
        ListNode right = pichla;
        while(left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

        
    }
}