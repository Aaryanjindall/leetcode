class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        // ListNode prev = null;
        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast != null && fast.next != null){
        //     prev = slow;
        //     slow = slow.next;
        //     fast = fast.next.next
        // }

        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            int data = curr.val;
            st.push(data);
            curr = curr.next;
            
        }
        ListNode curr2 = head;
        while(!st.isEmpty() && curr2 != null){
            int pull = st.pop();
            System.out.println(pull);
            if(curr2.val != pull){
                System.out.print(curr2.val +" "+pull);
                return false;
            }
            curr2 = curr2.next;
        }
        return true;


    }
}