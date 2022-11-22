package com.mashibing.cloudalibabaconfig3377.controller;

import java.util.*;

public class Test {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode f(int[] a, int l1, int r1, int[] b, int l2, int r2, HashMap<Integer, Integer> map) {
        if (l1 > r1) return null;
        TreeNode head = new TreeNode(a[l1]);
        if (l1 == r1) return head;
        int headIndex = map.get(a[l1]);
        head.left = f(a, l1 + 1, l1 + headIndex - l2, b, l2, headIndex - 1, map);
        head.right = f(a, l1 + headIndex - l2 + 1, r1, b, headIndex + 1, r2, map);
        return head;
    }


}
