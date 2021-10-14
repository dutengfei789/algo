package com.tengfei.algo.leetcode.editor.cn;

import java.util.List;

/**
 * 题号：【206】反转链表
 */
public class ReverseLinkedList{
  public static void main(String[] args) {

      ListNode node = ListNode.from(5);
      System.out.println(node);

      Solution solution = new ReverseLinkedList().new Solution();
      ListNode listNode = solution.reverseList(node);
      System.out.println(listNode);

  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //此处从整体看为。将链表头部之后链表整体翻转
        ListNode rev = reverseList(head.next);
        //此时head.next.next表示的是rev最后一个节点，要将最后一个节点指向head
        head.next.next = head;
        //此时head的下一个节点指的下一个节点依然是初始化链表的下一个接点next。next又代表反转后的链接指向了head，翻转后的链表表示为head->next->head。
        //head的下一个节点指向null才算最终翻转
        head.next = null;

        return rev;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
