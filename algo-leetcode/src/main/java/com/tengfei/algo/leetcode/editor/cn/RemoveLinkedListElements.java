package com.tengfei.algo.leetcode.editor.cn;

/**
 * 题号：【203】移除链表元素
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7,node1);
        ListNode node3 = new ListNode(7,node2);
        ListNode node4 = new ListNode(7,node3);
        ListNode node5 = new ListNode(7,node4);
        ListNode node6 = new ListNode(7,node5);
        ListNode node7 = new ListNode(7,node6);
        ListNode listNode = solution.removeElements(node7, 7);
        System.out.println("listNode = " + listNode);


    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            //终止条件。最基本单元
            if (head == null) {
                return null;
            }
            //最小解决单元
            head.next = removeElements(head.next, val);
            //当前节点，是否满足需要删除。需要删除的节点拼接下一个接点
            return head.val == val ? head.next : head;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
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

        @Override
        public String toString() {
            return val+"->";
        }
    }
}
