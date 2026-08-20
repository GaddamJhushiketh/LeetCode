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
12    public ListNode swapPairs(ListNode head) {
13        ListNode dummy = new ListNode(0);
14        dummy.next = head;
15        ListNode prev = dummy;
16        while(prev.next != null && prev.next.next != null){
17            ListNode first = prev.next;
18            ListNode sec = first.next;
19            prev.next = sec;
20            first.next = sec.next;
21            sec.next = first;
22            prev = first;
23        }
24        return dummy.next;
25    }
26}