package RotateList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int listNum = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            listNum++;
        }
        p.next = head;

        ListNode q = head;
        for (int i = 0; i < listNum - k % listNum - 1; i++) {
            q = q.next;
        }

        head = q.next;
        q.next = null;
        return head;
    }
}
