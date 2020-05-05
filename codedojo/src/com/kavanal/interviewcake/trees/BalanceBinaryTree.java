package com.kavanal.interviewcake.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class BalanceBinaryTree {

    // Use depth first search because that will hit leaves faster
    public static boolean isBalanced(BinaryTreeNode treeRoot) {
        if (treeRoot == null || (treeRoot.isLeaf())) {
            return true;
        }

        // Define a list of 3 - if there is more than that depth, we should return false
        List<Integer> depths = new ArrayList<>();

        Deque<NodeDepth> nodeDepths = new ArrayDeque<>();
        nodeDepths.push(new NodeDepth(treeRoot, 0));

        while (!nodeDepths.isEmpty()) {

            //Check the top of the stack
            NodeDepth nodeDepth = nodeDepths.pop();
            BinaryTreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;

            // Check for a leaf
            if (node.isLeaf()) {

                // If its a new depth, add it
                if (!depths.contains(depth)) {
                    depths.add(depth);
                }

                if (depths.size() > 2 || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                    return false;
                }
            } else {
                if (node.left != null) {
                    nodeDepths.push(new NodeDepth(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodeDepths.push(new NodeDepth(node.right, depth + 1));
                }
            }
        }

        return true;
    }

    public static class NodeDepth {
        public BinaryTreeNode node;
        int depth = 0;

        public NodeDepth(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode addLeft(int value) {
            this.left = new BinaryTreeNode(value);
            return this.left;
        }

        public BinaryTreeNode addRight(int value) {
            this.right = new BinaryTreeNode(value);
            return this.right;
        }

        public boolean isLeaf() {
            return (left == null && right == null);
        }
    }

    // tests

    @Test
    public void fullTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.addLeft(8);
        final BinaryTreeNode b = root.addRight(6);
        a.addLeft(1);
        a.addRight(2);
        b.addLeft(3);
        b.addRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final BinaryTreeNode root = new BinaryTreeNode(3);
        root.addLeft(4).addLeft(1);
        root.addRight(2).addRight(9);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByOneTest() {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.addLeft(1);
        root.addRight(0).addRight(7);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.addLeft(1);
        root.addRight(0).addRight(7).addRight(8);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        root.addLeft(5);
        final BinaryTreeNode b = root.addRight(9);
        b.addLeft(8).addLeft(7);
        b.addRight(5);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTwoTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        final BinaryTreeNode a = root.addLeft(2);
        a.addLeft(3);
        a.addRight(7).addRight(8);
        root.addRight(4).addRight(5).addRight(6).addRight(9);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void onlyOneNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void treeIsLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        root.addRight(2).addRight(3).addRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BalanceBinaryTree.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
