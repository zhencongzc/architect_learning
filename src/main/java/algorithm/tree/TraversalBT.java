package algorithm.tree;

import java.util.Stack;

/**
 * 遍历树
 */
public class TraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    //递归遍历
    public static void recursive(Node head) {
        if (head == null) return;
        //先序
        System.out.println(head.value);
        recursive(head.left);
        //中序
//        System.out.println(head.value);
        recursive(head.right);
        //后序
//        System.out.println(head.value);
    }

    //非递归先序遍历
    public static void pre(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.print(pop.value + " ");
                if (pop.right != null) stack.push(pop.right);
                if (pop.left != null) stack.push(pop.left);
            }
        }
        System.out.println();
    }

    //非递归中序遍历
    public static void in(Node cur) {
        System.out.print("in-order: ");
        if (cur != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    Node pop = stack.pop();
                    System.out.print(pop.value + " ");
                    cur = pop.right;
                }
            }
        }
        System.out.println();
    }

    //非递归后序遍历
    public static void pos1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                Node pop = stack1.pop();
                stack2.push(pop);
                if (pop.left != null) stack1.push(pop.left);
                if (pop.right != null) stack1.push(pop.right);
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    //单栈实现非递归后序遍历
    public static void pos2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

}