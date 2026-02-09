/*
328. Odd Even Linked List
Medium

00:01 read the problem
00:01 i think we check the length of linked list, and if it is above 2. we create an odd head, and even head. we traverse and update the links for odd elements with odd head, and even elements with even head. we keep a track of the even head, and we link the odd end to even head.
00:04 preparing the iterative function
00:14 i have written the code, it's working partially.
00:17 i know my approach is sound, it's just that the implementation is lacking.
00:25 i was in the ballpark of the solution. we use an evenHead, but the iteration is basically dependent on the even pointer. we move odd to even.next, even to even.next.next and the iteration runs till even = null or even.next = null. then we attach odd.next to evenHead;

 */

package LeetCode;

public class LC_328 {
    static void main() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = oddEvenList(head);
        printLL(head);
    }

    private static ListNode oddEvenList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
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
