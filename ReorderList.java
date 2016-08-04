/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = slow.next, newHead;
        while (tail.next != null) {
            newHead = tail.next;
            tail.next = newHead.next;
            newHead.next = slow.next;
            slow.next = newHead;
        }

        ListNode h1 = head, h2 = slow.next;
        while (h1 != slow) {
            slow.next = h2.next;
            h2.next = h1.next;
            h1.next = h2;
            h1 = h2.next;
            h1 = slow.next;
        }
    }
}