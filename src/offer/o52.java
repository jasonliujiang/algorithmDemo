package offer;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class o52 {
    /**
     * 如果顺序遍历时间复杂度为O(n2),我们可以想办法从尾部开始倒着遍历
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null||pHead2 == null){
            return null;
        }
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        ListNode l1 = pHead1;
        ListNode l2 = pHead2;

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode resultNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = (ListNode) stack1.pop();
            ListNode node2 = (ListNode) stack2.pop();

            if (node1.val==node2.val){
                resultNode = node1;
        }else {
                break;
            }
    }

        return resultNode;

}

    /**
     * 先遍历得出链表的长度，长的链表先执行，等到两个链表等长了再一起遍历
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null||pHead2 == null){
            return null;
        }

        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        int len1 = 0;
        int len2 = 0;

        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }

        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }

        int lengthdif = len1-len2;
        ListNode longNode = pHead1;
        ListNode shortNode = pHead2;
        if (len1<len2){
            lengthdif = len2-len1;
            longNode = pHead2;
            shortNode = pHead1;
        }

        for (int i = 0; i < lengthdif; i++) {
            longNode = longNode.next;
        }

        while (longNode!=null&&shortNode !=null){
            if (longNode.val !=shortNode.val){
                longNode = longNode.next;
                shortNode = shortNode.next;
            }else {
                break;
            }
        }
        return longNode;

    }
}
