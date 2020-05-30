package offer;

/**
 * 链表中环的入口节点
 *  给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class o23 {
    /**
     * 参考22题，设置两个指针，首先需要解决两个问题
     *  1.确定是否包含环：一个指针走两步一个指针走一步，如果追上了后面的则包含环
     *  2.确定环的位置：  计算出环有n个节点，一个指针先走n个节点，当两个指针相遇的时候即为环的入口
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {

        ListNode loopNode = findLoopNode(pHead);

        if (loopNode!=null){
            //计算环中节点的数量，快慢指针相遇一定在环中，通过计数循环一次获得
            int value = loopNode.val;
            int count = 1;
            while (loopNode.next.val != value){
                loopNode = loopNode.next;
                count++;
            }

            //确定环的位置
            ListNode first = pHead;
            ListNode second = pHead;
            for (int i = 0; i < count; i++) {
                first = first.next;
            }

            while (first.val!=second.val){
                first = first.next;
                second = second.next;
            }
            return first;


        }else {
            return null;
        }




    }
    public ListNode findLoopNode(ListNode pHead){
        if (pHead == null) {
            return null;
        }
        //第一次判断，一快一慢两个指针
        ListNode pFastNode = pHead;
        ListNode pSlowNode = pHead;


        while (pFastNode != null && pFastNode.next !=null) {
            pFastNode = pFastNode.next.next;
            pSlowNode = pSlowNode.next;
            if (pFastNode.val == pSlowNode.val){
                return pSlowNode;
            }

        }
        return null;
    }
}
