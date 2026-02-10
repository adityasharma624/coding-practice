/*
Sort a linked list of 0s, 1s and 2s
Difficulty: Medium

00:01 the first thought is to run different loops for every element. one for 0, one for 1, and one for 2.
while maintaining the relative order of the list. wait a minute, i can also count the number of 0s 1s and 2s and just return a new linked list.
00:17 minutes, and the code is so verbose, i am definitely on the wrong path
it was basically counting the number of 0s 1s and 2s and just updating the list wtf (time: O(N), space O(N))
another approach is what i was trying. i just overcomplicated.
we use a curr pointer to iterate through the list, when we encounter 0,1,2 we just point to it using the appropriate pointer and then move curr forward.
the major issue was that i thought that solution must be something complicated
 */

package GFG;

public class sortZeroesOnesTwos {
    static void main() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(2);

        head = segregate(head);
        printLL(head);
    }

    private static Node segregate(Node head) {
        Node headZero = new Node(0);
        Node headOne = new Node(1);
        Node headTwo = new Node(2);

        Node zero = headZero, one = headOne, two = headTwo;

        Node curr = head;

        while (curr != null)
        {
            if (curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }

            else if (curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }

            else
            {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        if (headOne.next != null)
        {
            zero.next = headOne.next;
        }
        else
        {
            zero.next = headTwo.next;
        }

        one.next = headTwo.next;
        two.next = null;

        head = headZero.next;
        return head;
    }

    private static void printLL(Node root)
    {
        Node temp = root;
        while (temp!=null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
