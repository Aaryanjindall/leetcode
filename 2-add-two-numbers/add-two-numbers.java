class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode curr = new ListNode(-1);
        ListNode dummy = curr;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;
            int sum = x+y+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            if(l1 != null)l1 = l1.next;
            if(l2 != null)l2 = l2.next;
            dummy = dummy.next;
        }
        if(carry > 0){
            dummy.next = new ListNode(carry);
        }
        return curr.next;
    }
}