package offer;

/**
 * 删除链表节点
 * 给定头节点和要删除的节点，在O(1)时间复杂度内完成
 */
public class o18_1 {
    //先获得删除指针的下一个指针内容，把下个指针的内容复制到当前指针上，然后删除下一个的指针；
    public ListNode deleteNode(ListNode pHead,ListNode pToBeDel){
        if (pHead == null || pToBeDel == null){
            return null;
        }

        //要删除的节点不是尾节点
        if (pToBeDel.next!=null){
            ListNode pNext = pToBeDel.next;

            pToBeDel.val = pNext.val;
            pToBeDel.next = pNext.next;

            pNext = null;

        //链表只有一个节点
        } else if (pHead == pToBeDel) {
            pHead = null;
            pToBeDel = null;

            //删除尾节点
        }else {
            ListNode pNode = pHead;
            while (pNode.next!=pToBeDel){
                pNode = pNode.next;
            }

            pNode.next  = null;
            pToBeDel = null;
        }

        return pHead;


    }
}
