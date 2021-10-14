package com.tengfei.algo.leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode from(int count) {
        ListNode next = null;
        for (int i = 0; i < count; i++) {
            next = new ListNode(i, next);
        }
        return next;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (ListNode cur = this; cur != null; cur = cur.next) {
            sb.append(cur.val).append("->");
        }
        sb.append("NULL");
        return sb.toString();
    }
}