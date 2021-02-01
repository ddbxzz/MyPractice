package DeleteDuplicatesList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;

        while ((q = q.next) != null) {
            if (p.val != q.val) {
                p.next = q;
                p = q;
            }
        }

        p.next = null;
        return head;
    }
}
