1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode mergeKLists(ListNode[] lists) {
13        if(lists == null ||lists.length == 0){
14            return null;
15        }
16        PriorityQueue<ListNode> temp = new PriorityQueue<>((a,b)->a.val-b.val);
17        for(ListNode node : lists){
18            if(node!=null){
19                temp.add(node);
20            }
21        }
22        ListNode ans = new ListNode(0);
23        ListNode curr = ans;
24        while(!temp.isEmpty()){
25            ListNode smallest = temp.poll();
26            curr.next = smallest;
27            curr = curr.next;
28            if (smallest.next != null) {
29                temp.add(smallest.next);
30            }
31        }
32        return ans.next;
33    }
34}