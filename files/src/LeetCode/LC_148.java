/*
148. Sort List
Medium
 */

package LeetCode;

public class LC_148 {
    static void main() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        head = sortList(head);
        printLL(head);

    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        if (l1 != null)
        {
            p.next = l1;
        }

        if (l2 != null)
        {
            p.next = l2;
        }

        return l.next;
    }

    private static void printLL(ListNode root)
    {
        ListNode temp = root;
        while (temp!=null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
