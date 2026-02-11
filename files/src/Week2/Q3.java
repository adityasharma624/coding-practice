package Week2;

public class Q3 {
    static class Node {
        boolean broken;
        Node left;
        Node right;

        Node(boolean broken) {
            this.broken = broken;
        }

        Node(boolean broken, Node left, Node right) {
            this.broken = broken;
            this.left = left;
            this.right = right;
        }
    }

    static void main() {
        Node tree = new Node(false,
                new Node(true),
                new Node(false,
                        new Node(false),
                        null));             // hardcoded sample
        int k = 1;
        System.out.println(canReachCapital(tree, k));
    }

    static boolean canReachCapital(Node root, int k) {
        if (root == null) {
            return true;
        }
        return countBroken(root) <= k;
    }

    private static int countBroken(Node node) {
        if (node == null) {
            return 0;
        }
        int count = node.broken ? 1 : 0;
        count += countBroken(node.left);
        count += countBroken(node.right);
        return count;
    }
}
