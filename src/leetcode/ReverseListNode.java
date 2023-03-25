package leetcode;

import data_struct.ListNode;

/**
 * @author 孙勇
 * @date 2023/2/23
 */
public class ReverseListNode {

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseListNode obj = new ReverseListNode();
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode listNode = ListNode.init(arr);
        listNode = obj.reverse2(listNode, 2,5);
        ListNode.print(listNode);
    }

    // 1 2 3 4 5

    // 1 3 2 4 5
    // >> 1 4 3 2 5
    public ListNode reverse2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head, pre = dummy;
        for (int i = 1; i < left; i ++) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = left; i < right; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }


}
