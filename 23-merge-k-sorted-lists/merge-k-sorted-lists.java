class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i = 0 ; i < lists.length ; i++){
            ListNode cur = lists[i];
            if(cur != null){
                pq.add(cur);
            } 
        }
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = new ListNode(curr.val);
            temp = temp.next;
            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}