/*
237. Delete Node in a Linked List
Medium

00:01 read the problem. one solution might be to first copy the next node's value, and then delete the next node.
00:03 accepted.
 */

package LeetCode;


class ListNode
{
    int val;
    ListNode next;
    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

public class LC_237 {
    static void main() {
        ListNode head = new ListNode(4);
        ListNode current = head;
        current.next = new ListNode(5);
        current = current.next;
        current.next = new ListNode(1);
        current = current.next;
        current.next = new ListNode(9);
        deleteNode(current);
        printLL(head);
    }
    public static void deleteNode(ListNode node) {
        ListNode delete = node.next;
        node.val = delete.val;
        node.next = delete.next;
        delete.next = null;
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
