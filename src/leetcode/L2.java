package leetcode;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tag = 0;
        ListNode result = new ListNode(-1);

        ListNode node = result;
        ListNode p = l1;
        ListNode q = l2;

        while (p != null || q != null) {
            int num1 = (p != null) ? p.val : 0;
            int num2 = (q != null) ? q.val : 0;

            int sum = num1 + num2 + tag;

            tag = sum / 10;

            node.next = new ListNode(sum % 10);

            node = node.next;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }

        }
        if (tag > 0) {
            node.next = new ListNode(tag);
        }

        return result.next;


    }
}
