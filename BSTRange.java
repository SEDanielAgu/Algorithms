/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Agu
 */
public class BSTRange {

    // tree node class used to build a binary search tree
    public class TreeNode {

        int nodeValue;
        TreeNode leftChild = null;
        TreeNode rightChild = null;

        // onstructor for a tree node that accepts the nodes children and the value of the node
        public TreeNode(int a, TreeNode l, TreeNode r) {
            nodeValue = a;
            leftChild = l;
            rightChild = r;
        }

        // onstructor for a tree node that accepts value of the node
        public TreeNode(int a) {
            nodeValue = a;
        }

        // get methods for the node
        public int getValue() {
            return nodeValue;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        // set methods for the node
        public void setValue(int a) {
            nodeValue = a;
        }

        public void setLeftChild(TreeNode l) {
            leftChild = l;
        }

        public void setRightChild(TreeNode r) {
            rightChild = r;
        }
    }

    TreeNode root;

    // set method for the root of the tree
    public void setRoot(TreeNode n) {
        root = n;
    }

    // get method for the root of the tree
    public TreeNode getRoot() {
        return root;
    }

    // the method takes a node containing a binary search tree and a range to find nodes that fall in it
    public void printRange(TreeNode node, int k1, int k2) {
        if (node != null) {                                     // check to see if the binary tree is empty
            if (node.getValue() > k1) {                         // recursively checks the left subtree to find nodes with values within the range
                printRange(node.getLeftChild(), k1, k2);        
            }
            if (k1 <= node.getValue() && node.getValue() <= k2) {   // if the node value is in the range print it out
                System.out.println(node.getValue() + "");
            }
            if (node.getValue() < k2) {                         // recursively checks the right subtree to find nodes with values within the range
                printRange(node.getRightChild(), k1, k2);
            }
        }
    }
}
