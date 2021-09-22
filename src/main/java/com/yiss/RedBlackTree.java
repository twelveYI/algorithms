
package com.yiss;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public class Node {

        // 左右节点；key，value，数量
        private Key key;
        private Value value;
        private int N;
        private Node right;
        private Node left;
        private boolean color;

        public Node(Key key, Value value, Node right, Node left, boolean color) {
            this.key = key;
            this.value = value;
            this.right = right;
            this.left = left;
            this.color = color;
            this.N = 1;
        }

    }


    public boolean isRED(Node node) {
        if (node == null) return false;
        return node.color == RED;
    }


    // 左旋、右旋；颜色翻转；put操作；遍历操作；
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        // 设置颜色
        x.color = h.color;
        h.color = BLACK;

        // 这里设置数量
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        // 设置颜色
        x.color = h.color;
        h.color = RED;

        // 这里设置数量
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void flipColors(Node h) {
        h.right.color = BLACK;
        h.left.color = BLACK;
        h.color = RED;
    }

    public void put(Key key, Value value) {
        if (root == null) {
            root = new Node(key, value, null, null, BLACK);
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        } else if (cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
    }

    public Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, null, null, BLACK);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.value = val;
        }

        // 插入节点后，有三种情况：分别对应左旋、右旋、红色节点上升;
        // 注意：这几种情况有先后顺序，有些场景，三个if分支语句都会执行
        if (isRED(h.right) && !isRED(h.left)) {
            h = rotateLeft(h);
        }
        if (isRED(h.left) && isRED(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRED(h.left) && isRED(h.right)) {
            flipColors(h);
        }

        // 计算节点数量
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public int size() {
        return size(root);
    }

    public int size(Node node) {
        // 空指针
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public Node root;

    public Iterable<Key> keys() {
        return keys(min(root), max(root));
    }

    // 遍历
    public Iterable<Key> keys(Node from, Node to) {
        Queue<Key> queue = new LinkedList<>();
        keys(queue, root, from, to);
        return queue;
    }

    // 遍历
    public void keys(Queue<Key> queue, Node x, Node lo, Node hi) {
        if (x == null) {
            return;
        }
        int cmpLo = lo.key.compareTo(x.key);
        int cmpHi = hi.key.compareTo(x.key);

        if (cmpLo < 0) keys(queue, x.left, lo, hi);
        if (cmpLo <= 0 && cmpHi >= 0) queue.add(x.key);
        if (cmpHi > 0) keys(queue, x.right, lo, hi);
    }

    // todo 区分左、右子节点。
    public int rank(Node node) {
        return size(node);
    }

    public Node min() {
        return min(root);
    }

    public Node min(Node node) {
        if (node == null || node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Node max() {
        return max(root);
    }

    public Node max(Node node) {
        if (node == null || node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public static void main(String[] args) {
        RedBlackTree<String, Integer> tree = new RedBlackTree<String, Integer>();
        tree.put("a", 1);
        tree.put("b", 2);
        tree.put("c", 3);
        tree.put("d", 4);
        tree.put("e", 5);
        tree.put("f", 6);
        tree.put("g", 7);
        System.out.println(tree.min().value);
        System.out.println(tree.max().value);
        System.out.println(String.join(",", tree.keys()));
    }

}
