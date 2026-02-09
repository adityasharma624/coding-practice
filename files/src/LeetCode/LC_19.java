/*
19. Remove Nth Node From End of List
Medium

00:01 read the problem.
a simple approach would be to calculate the total length of list, then calculate where the node stands from the beginning, and remove it accordingly
the follow up which is "Could you do this in one pass?" is interesting. i can create two pointers, one will be curr+2 nodes ahead, and then we can do the procedure.
00:02 doing some dry runs, this is actually quite easier than removing an element from the list.
00:11 my code does not work for removing first elements. hmm.
00:16 the only thing i was not checking for was that if next became null in the initial iteration of creating that gap, it meant that the first element was to be removed, so i returned head.next.
00:17 accepted
 */

package LeetCode;

public class LC_19 {
    static void main()
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);


        head = removeNthFromEnd(head, 2);
        printLL(head);
    }

    private static ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head.next == null)
        {
            return null;
        }

        ListNode curr = head;
        ListNode next = head;
        while (n > 0)
        {
            next = next.next;
            --n;
        }

        if (next == null)
            return head.next;

        while (next.next != null)
        {
            curr = curr.next;
            next = next.next;
        }

        curr.next = curr.next.next;
        return head;
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
