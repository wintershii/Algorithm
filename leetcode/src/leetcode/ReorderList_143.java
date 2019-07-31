package leetcode;

import java.util.LinkedList;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList_143 {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.addLast(node);
            node = node.next;
        }
        while (!list.isEmpty()) {
            if (node == null) {
                node = list.pollFirst();
            } else {
                node.next = list.pollFirst();
                node = node.next;
            }
            node.next = list.pollLast();
            node = node.next;
        }
        if (node != null) {
            node.next = null;
        }
    }
}
