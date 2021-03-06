package top2020.day0905;

/**
 * 两两交换链表中的节点
 */
public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode pre = null;
        while (node != null && node.next != null) {
            if (node == head) {
                head = node.next;
            }
            if (pre != null) {
                pre.next = node.next;
            }
            ListNode tmp = node.next.next;
            node.next.next = node;
            node.next = tmp;
            pre = node;
            node = node.next;
        }
        return head;
    }
}
