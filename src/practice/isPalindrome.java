package practice;

/**
 * 判断一个链表是否是回文链表
 */
public class isPalindrome {
    /**第三种实现方案，实现的思路是将后半部分的链表倒置，然后这个链表链表分别从两点开始遍历，对比元素是否是相等的，然后再将链表还原
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverseList(slow.next);

        while (head != null && reverseHead != null) {
            if (head.val != reverseHead.val)
                return false;
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = null;
        ListNode q;
        while (head != null) {
            q = head.next;
            head.next = p;

            p = head;
            head = q;
        }
        return p;
    }
}
