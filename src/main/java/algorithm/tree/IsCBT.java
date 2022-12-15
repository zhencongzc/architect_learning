package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否是完全二叉树，除最后一层都是满的，并且最后一层也是从左向右趋向满的树
 */
public class IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT1(Node head) {
        if (head == null) return true;
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        Node l;
        Node r;
        boolean flag = false;//是否出现过两孩子不双全的情况
        while (!q.isEmpty()) {
            Node poll = q.poll();
            l = poll.left;
            r = poll.right;
            //有右孩无左孩，或者flag为true时出现了非子叶节点，返回false
            if ((r != null && l == null) ||
                    (flag && (l != null || r != null))) return false;
            if (l != null) q.add(l);
            if (r != null) q.add(r);
            if (l == null || r == null) flag = true;
        }
        return true;
    }

    public static boolean isCBT2(Node head) {
        if (head == null) return true;
        return process(head).isCBT;
    }

    // 对每一棵子树，是否是满二叉树、是否是完全二叉树、高度
    public static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean full, boolean cbt, int h) {
            isFull = full;
            isCBT = cbt;
            height = h;
        }
    }

    public static Info process(Node X) {
        if (X == null) return new Info(true, true, 0);
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        boolean isCBT = false;
        if (isFull) {
            isCBT = true;
        } else { // 以x为头整棵树，不满
            if (leftInfo.isCBT && rightInfo.isCBT) {
                if (leftInfo.isFull && leftInfo.height == rightInfo.height) isCBT = true;
                if (rightInfo.isFull && leftInfo.height == rightInfo.height + 1) isCBT = true;
            }
        }
        return new Info(isFull, isCBT, height);
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}