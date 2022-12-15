package algorithm.tree;

import java.util.ArrayList;

/**
 * 是否是二叉搜索树，对任一个节点，它的左树最大值小于当前节点，右树最小值大于当前节点，默认没有重复值
 */
public class IsBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBST1(Node head) {
        if (head == null) return true;
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) return false;
        }
        return true;
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) return;
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static boolean isBST2(Node head) {
        if (head == null) return true;
        return process(head).isBST;
    }

    private static Info process(Node head) {
        if (head == null) return null;
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        int max = head.value;
        int min = head.value;
        boolean isBST = true;
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            isBST = leftInfo.isBST ? isBST : false;
            isBST = leftInfo.max < head.value ? isBST : false;
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            isBST = rightInfo.isBST ? isBST : false;
            isBST = rightInfo.min > head.value ? isBST : false;
        }
        return new Info(isBST, max, min);
    }

    public static class Info {
        private boolean isBST;
        private int max;
        private int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBST2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}