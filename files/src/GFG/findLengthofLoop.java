/*
Find length of Loop
Medium

 */

package GFG;

public class findLengthofLoop {
    static void main() {

    }

    public static int lengthOfLoop(Node head)
    {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return 0;

        while (head != slow)
        {
            head = head.next;
            slow = slow.next;
        }

        int count = 1;
        Node countNode = slow.next;

        while (countNode != slow)
        {
            count++;
            countNode = countNode.next;
        }

        return count;
    }

}
