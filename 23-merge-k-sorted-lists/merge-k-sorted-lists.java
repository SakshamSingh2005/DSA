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
class Solution{
    public ListNode mergeKLists(ListNode[] a){
        PriorityQueue<ListNode> pq=new PriorityQueue<>((x,y)->x.val-y.val);
        for(ListNode n:a) if(n!=null) pq.add(n);
        ListNode d=new ListNode(0),c=d;
        while(!pq.isEmpty()){
            ListNode t=pq.poll();
            c.next=t;
            c=c.next;
            if(t.next!=null) pq.add(t.next);
        }
        return d.next;
    }
}
