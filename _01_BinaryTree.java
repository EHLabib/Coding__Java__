package Partice;

import java.util.LinkedList;
import java.util.Queue;

public class _01_BinaryTree {

    // Node creation.............
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    // Pre order traverse............
    public static void pre_order(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        pre_order(root.left);
        pre_order(root.right);
    }

    // In order traverse............
    public static void in_order(Node root) {
        if (root == null) {
            return;
        }
        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    // Post order traverse............
    public static void post_order(Node root) {
        if (root == null) {
            return;
        }
        post_order(root.left);
        post_order(root.right);
        System.out.print(root.data + " ");
    }

    //Level order traversal.........
    public static void level_order(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // Count nodes
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    // Sum of nodes
    public static int sumofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumofNodes(root.left);
        int rightSum = sumofNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    // Height of nodes........
    public static int heightofNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightofNodes(root.left);
        int rightHeight = heightofNodes(root.right);
        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    // Diameter of nodes..........
    public static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diama3 = heightofNodes(root.left) + heightofNodes(root.right) + 1;
        return Math.max(diama3, Math.max(diam1, diam2));
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree Tree = new BinaryTree();
        Node root = Tree.buildTree(nodes);
        System.out.print("\n\n ");
        System.out.println("Root Data = " + root.data);

        System.out.print("Pre_order Traverse : ");
        pre_order(root);
        System.out.print("\n\n ");

        System.out.print("In_order Traverse : ");
        in_order(root);
        System.out.print("\n\n ");

        System.out.print("Post_order Traverse : ");
        post_order(root);
        System.out.print("\n\n ");

        System.out.println("Level order Traverse : ");
        level_order(root);
        System.out.print("\n\n ");

        System.out.print("Count of nodes : ");
        System.out.print(countNodes(root));
        System.out.print("\n\n ");

        System.out.print("Sum of nodes : ");
        System.out.print(sumofNodes(root));
        System.out.print("\n\n ");

        System.out.print("Hight of nodes : ");
        System.out.print(heightofNodes(root));
        System.out.print("\n\n ");

        System.out.print("Diameter of nodes : ");
        System.out.print(diameter(root));
        System.out.print("\n\n ");
    }

}
