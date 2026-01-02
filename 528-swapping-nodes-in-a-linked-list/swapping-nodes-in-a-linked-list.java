class Solution {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;
        ListNode second = head;

        // 1️⃣ first ko kth node tak le jao
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        // 2️⃣ second ko tab move karo jab first end ki taraf jaaye
        ListNode temp = first;
        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        // 3️⃣ values swap
        int t = first.val;
        first.val = second.val;
        second.val = t;

        return head;
    }
}
