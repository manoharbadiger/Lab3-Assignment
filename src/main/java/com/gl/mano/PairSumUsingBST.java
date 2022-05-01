package com.gl.mano;

import java.util.ArrayList;

class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(40);
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(50);
        tree.insert(70);

        tree.isPairPresent(tree.root, 1000);
    }

    void inorder() {
        inorderNodeCreation(this.root);
    }

    void inorderNodeCreation(Node node) {
        if (node == null)
            return;

        inorderNodeCreation(node.left);
        System.out.print(node.data + " ");
        inorderNodeCreation(node.right);
    }

    void insert(int key) {
        root = insertNodeValues(root, key);
    }

    Node insertNodeValues(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertNodeValues(root.left, data);
        else if (data > root.data)
            root.right = insertNodeValues(root.right, data);

        return root;
    }

    ArrayList<Integer> treeToList(Node node, ArrayList<Integer> list) {
        if (node == null)
            return list;
        treeToList(node.left, list);
        list.add(node.data);
        treeToList(node.right, list);
        return list;
    }

    boolean isPairPresent(Node node, int target) {

        ArrayList<Integer> resultList = new ArrayList<>();

        ArrayList<Integer> nodeList = treeToList(node, resultList);

        int start = 0;

        int end = nodeList.size() - 1;

        while (start < end) {

            if (nodeList.get(start) + nodeList.get(end) == target) {
                System.out.println("Pair Sum exists: " + nodeList.get(start) + " + " + nodeList.get(end) + " "
                        + "= " + target);
                return true;
            }

            if (nodeList.get(start) + nodeList.get(end) > target) {
                end--;
            }

            if (nodeList.get(start) + nodeList.get(end) < target) {
                start++;
            }
        }

        System.out.println("No com.gl.mano.Node value exists to match the sum value!");
        return false;
    }
}


