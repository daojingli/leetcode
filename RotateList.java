/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode walker = sentinel;
        int size = 0;
        while (walker.next != null) {
            walker = walker.next;
            size++;
        }
        if (size == 0) return head;
        if (k >= size) k = k % size;
        if (k == 0) return head;
        
        walker = sentinel;
        int count = size - k;
        while (count > 0) {
            walker = walker.next;
            count--;
        }
        sentinel.next = walker.next;
        walker.next = null;
        walker = sentinel.next;
        while (walker.next != null) walker = walker.next;
        walker.next = head;
        return sentinel.next;
    }
}