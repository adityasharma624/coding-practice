package LeetCode;

public class LC_141 {
    static void main() {
        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create the cycle: -4 -> 2
        node4.next = node2;

        // Head of the linked list
        ListNode head = node1;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head)
    {
        if (head == null)
            return false;
        if (head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }
        return false;
    }


}
