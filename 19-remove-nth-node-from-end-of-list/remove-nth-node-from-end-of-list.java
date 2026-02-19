class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        if(head == null || head.next == null){
            return null;
        }
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            return head.next;
        }
        int idx = size-n;
        ListNode temp2 = head;
        for(int i = 0 ; i < idx-1 ; i++){
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        System.out.println(size);

        return head;
    }
}