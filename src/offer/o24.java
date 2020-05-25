package offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class o24 {
    public ListNode ReverseList(ListNode head) {
        //判断特殊边界值
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
