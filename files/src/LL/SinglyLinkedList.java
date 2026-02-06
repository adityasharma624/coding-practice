package LL;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    static void main() {
        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);

        printLL(root);
        root = insertBeginning(root, 0);
        printLL(root);
        insertEnding(root, 40);
        printLL(root);
        insertSpecificPosition(root, 3, 35);
        printLL(root);
        root = insertSpecificPosition(root, 6, 45);
        printLL(root);
        root = removeBeginning(root);
        printLL(root);
        removeEnd(root);
        printLL(root);
    }

    private static void removeEnd(Node head)
    {
        Node curr = head;
        while (curr.next.next != null)
        {
            curr = curr.next;
        }
        curr.next = null;
    }
    private static Node removeBeginning(Node head)
    {
        Node result = head.next;
        head.next = null;
        return result;
    }

    private static Node insertBeginning(Node root, int data) {
        Node result = new Node(data);
        result.next = root;
        return result;
    }

    private static void insertEnding(Node root, int data)
    {
        Node temp = root;
        while (temp.next!=null)
        {
            temp = temp.next;
        }
        Node result = new Node(data);
        temp.next = result;
    }

    private static Node insertSpecificPosition(Node head, int pos, int val)
    {
        Node newNode = new Node(val);

        if (pos == 1)
        {
            newNode.next = head;
            return newNode;
        }

        int count = 1;
        Node curr = head;
        while (curr.next != null && count < pos - 1)
        {
            curr = curr.next;
            count++;
        }
        Node next = curr.next;
        curr.next = newNode;
        newNode.next = next;
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
