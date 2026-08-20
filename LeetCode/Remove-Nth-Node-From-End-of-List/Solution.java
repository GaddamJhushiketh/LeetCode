1class Solution {
2    public ListNode removeNthFromEnd(ListNode head, int n) {
3        ListNode dummy = new ListNode(0);
4        dummy.next = head;
5        ListNode fast = dummy;
6        ListNode slow = dummy;
7        for(int i=0;i<n;i++){
8            fast = fast.next;
9        }
10        while(fast.next != null){
11            fast = fast.next;
12            slow = slow.next;
13        }
14            slow.next = slow.next.next;
15            return dummy.next;
16    }
17}