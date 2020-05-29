package offer;

/**
 * 删除链表中重复节点
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class o18_2 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode preNode = null;
        ListNode pNode = pHead;
        while (pNode != null) {
            ListNode nextNode = pNode.next;
            boolean needDel = false;

            if (nextNode != null && nextNode.val == pNode.val) {
                needDel = true;
            }

            if (!needDel) {
                preNode = pNode;
                pNode = pNode.next;
            } else {
                int value = pNode.val;

                while (pNode != null && pNode.val == value) {
                    pNode = pNode.next;

                }
                nextNode = pNode.next;
                if (preNode == null) {
                    pHead = pNode;
                } else {
                    preNode.next = pNode;
                }
            }
        }
        return pHead;

    }

}
