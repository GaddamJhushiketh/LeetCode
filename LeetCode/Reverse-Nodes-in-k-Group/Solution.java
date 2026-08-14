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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        if(head == null || k ==1){
14            return head;
15        }
16        ListNode dummy = new ListNode(0);
17        dummy.next = head;
18        ListNode group = dummy;
19        while(true){
20            ListNode temp = group;
21            for(int i =0;(i<k) && (temp != null);i++){
22                temp = temp.next;
23            }
24            if(temp == null){
25                break;
26            }
27            ListNode groupnext = temp.next;
28            ListNode prev = groupnext;
29            ListNode curr = group.next;
30            while(curr != groupnext){
31                ListNode dube = curr.next;
32                curr.next = prev;
33                prev = curr;
34                curr = dube;
35            }
36            ListNode dube = group.next;
37            group.next = temp;
38            group = dube; 
39        }
40        return dummy.next;
41    }
42}
43