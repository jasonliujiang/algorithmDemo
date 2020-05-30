package offer;
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class o35 {
    /**
     * 最精简的算法分如下3步
     * 还有一种用空间换时间的方法，用哈希表记录下每个节点和复制节点的11对应关系
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        CloneNodes(pHead);
        ConnectSliblingNodes(pHead);
        return ReconnectNodes(pHead);
    }

    /**
     * 3.把复制好的链表拆分出来，奇数位置的节点用next连起来就是原来链表。偶数位置连起来就是复制链表
     * @param pHead
     * @return
     */
    private RandomListNode ReconnectNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode clonedHead = null;
        RandomListNode clonedNode = null;

        //设置头指针
        if (node != null) {
            clonedHead = node.next;
            clonedNode = node.next;

            //node指向对应下一个节点，方便后边的遍历
            node.next = clonedNode.next;
            node = node.next;
        }

        while (node!=null){
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;

            node.next = clonedNode.next;
            node = node.next;
        }

        return clonedHead;

    }

    /**
     *
     * 2.复制随机指针，N的随机指针指向S，N’指向S’
     * @param pHead
     */
    private void ConnectSliblingNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node !=null){
            RandomListNode cloneNode = node.next;
            //注意空指针异常
            if (node.random != null){
                cloneNode.random = node.random.next;
            }

            node = cloneNode.next;
        }
    }

    /**
     * 1.在每一个结点的后面插入要复制的结点N’，在把N'连接到N的后面
     * @param pHead
     */
    private void CloneNodes(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node!=null){
            RandomListNode cloned = new RandomListNode(node.label);

            cloned.label = node.label;
            cloned.next = node.next;
            cloned.random = null;
            node.next = cloned;

            //继续向下遍历
            node = cloned.next;

        }

    }
}
