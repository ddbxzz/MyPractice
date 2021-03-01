package SwapNodesPairs;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {

        return swap1(head);
    }

    //递归
    private ListNode swap1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swap1(next.next);

        next.next = head;

        return next;
    }

    //迭代
    private ListNode swap2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return dummy.next;
    }

}
