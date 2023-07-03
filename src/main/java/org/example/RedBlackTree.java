package org.example;

public class RedBlackTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }
    public boolean contains(int value) {
        final TreeNode node = findNode(root, value);
        return node != null;
    }

    private TreeNode findNode(TreeNode node, int value) {
        if (node.value == value) {
            return node;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    return findNode(node.leftChild, value);
                } else {
                    return null;
                }
            } else {
                if (node.rightChild != null) {
                    return findNode(node.rightChild, value);
                } else {
                    return null;
                }
            }
        }
    }

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.Black;
            return result;
        } else {
            root = new TreeNode();
            root.color = Color.Black;
            root.value = value;
            return true;
        }
    }
    private boolean addNode(TreeNode node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new TreeNode();
                    node.leftChild.color = Color.Red;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new TreeNode();
                    node.rightChild.color = Color.Red;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private TreeNode rebalance(TreeNode node) {
        TreeNode result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.Red &&
                    (result.leftChild == null || result.leftChild.color == Color.Black)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.Red &&
                    result.leftChild.leftChild != null && result.leftChild.color == Color.Red) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.Red &&
                    result.rightChild != null && result.rightChild.color == Color.Red) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private TreeNode rightSwap(TreeNode node) {
        TreeNode rightChild = node.rightChild;
        TreeNode betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.Red;
        return rightChild;
    }
    private TreeNode leftSwap(TreeNode node) {
        TreeNode leftChild = node.leftChild;
        TreeNode betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.Red;
        return leftChild;
    }
    private void colorSwap(TreeNode node) {
        node.rightChild.color = Color.Black;
        node.leftChild.color = Color.Black;
        node.color = Color.Red;
    }

    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }

        showTrunks(p.prev);
        System.out.print(p.str);
    }

    public static void printTree(TreeNode root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);

        printTree(root.rightChild, trunk, true);

        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        }
        else {
            trunk.str = "`———";
            prev.str = prev_str;
        }

        showTrunks(trunk);
        System.out.println(" " + root.value);

        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";

        printTree(root.leftChild, trunk, false);
    }
    private class TreeNode {
        private int value;
        private Color color;
        private TreeNode leftChild;
        private TreeNode rightChild;

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", color=" + color + "}";
        }
    }

    private enum Color {
        Red, Black
    }
    static class Trunk
    {
        Trunk prev;
        String str;

        Trunk(Trunk prev, String str)
        {
            this.prev = prev;
            this.str = str;
        }
    }

}
