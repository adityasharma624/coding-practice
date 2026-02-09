/*
142. Linked List Cycle II
Medium

 */

package LeetCode;

public class LC_142 {
    static void main() {

    }

    public static ListNode detectCycle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;

        while (head != slow)
        {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
