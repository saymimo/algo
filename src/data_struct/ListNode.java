package data_struct;

/**
 * @author 孙勇
 * @date 2023/2/23
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode init(int[] arr){
        ListNode node = new ListNode(0);
        ListNode cur = node;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return node.next;
    }

    public static void print(ListNode node){
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println("");
    }

}
