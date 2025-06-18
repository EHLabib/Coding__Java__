package Partice;

import java.util.ArrayList;

public class _02_Binary_search_Tree {

    // Node diclaration...........
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    //Insertion of nodes.............
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // In order traverse..........
    public static void in_order(Node root) {
        if (root == null) {
            return;
        }
        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    // Searching..............
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    // Deleting a node...........
    public static Node delete_node(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data > val) {
            root.left = delete_node(root.left, val);
        } else if (root.data < val) {
            root.right = delete_node(root.right, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            Node IS = inordersuccsor(root.right);
            root.data = IS.data;
            root.right = delete_node(root.right, IS.data);
        }
        return root;
    }

    public static Node inordersuccsor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print in range values..........
    public static void printinRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            printinRange(root.left, x, y);
            System.out.print(root.data + " ");
            printinRange(root.right, x, y);
        } else if (root.data >= y) {
            printinRange(root.left, x, y);
        } else {
            printinRange(root.right, x, y);
        }
    }

    // Printing leaf to root path...........
    public static void printleaftoroot(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printpath(path);
        } else {
            printleaftoroot(root.left, path);
            printleaftoroot(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void printpath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.print("\n\n");
        in_order(root);
        System.out.print("\n\n");

        if (search(root, 6)) {
            System.out.println("Found");
        } else {
            System.out.print("Not Found");
        }
        System.out.print("\n\n");

        root = delete_node(root, 2);
        in_order(root);
        System.out.print("\n\n");

        printinRange(root, 3, 7);
        System.out.print("\n\n");

        printleaftoroot(root, new ArrayList<>());
    }
}
