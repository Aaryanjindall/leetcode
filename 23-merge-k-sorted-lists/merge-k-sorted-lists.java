class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode curr: lists){
            if(curr != null){
                pq.add(curr);
            }
        }
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;
            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}