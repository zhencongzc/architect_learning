package algorithm.node;

/**
 * 寻找链表交点
 * 两个链表可能有环，寻找其相交节点，没有返回null
 */
public class Code01_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) return noLoop(head1, head2);
        if (loop1 != null && loop2 != null) return bothLoop(head1, loop1, head2, loop2);
        return null;
    }

    //找链表循环部分的第一个节点，无循环返回null
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        //快慢指针
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            //无环的情况
            if (fast.next == null || fast.next.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        //当快慢指针相等时，快指针回到头结点逐个遍历，同时慢指针继续遍历，再次相等时即为循环部分第一个节点
        //x:环外长度 y1:环交点到快慢指针交点距离 y2:快慢指针交点到环交点距离 n:0或正整数
        //x = n * (y1 + y2) + y2
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static Node noLoop(Node head1, Node head2) {
        //1如果尾结点不相同，那么无交点
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) return null;
        //2如果相同，找第一个交点
        cur1 = n > 0 ? head1 : head2;//长链表
        cur2 = cur1 == head1 ? head2 : head1;//短链表
        n = Math.abs(n);
        while (n-- > 0) {
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1;
        Node cur2;
        //1如果环交点相同，则相交于环外
        if (loop1 == loop2) {
            int n = 0;
            cur1 = head1;
            cur2 = head2;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;//长链表
            cur2 = cur1 == head1 ? head2 : head1;//短链表
            n = Math.abs(n);
            while (n-- > 0) {
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        //2环交点不同,相交于环上
        cur1 = loop1.next;
        while (cur1 != loop1) {
            if (cur1 == loop2) return loop1;
            cur1 = cur1.next;
        }
        //3无相交
        return null;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}