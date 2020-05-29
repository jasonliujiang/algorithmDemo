package offer;
/*
* 输入一个链表，输出该链表中倒数第k个结点。
* */
public class o22 {
    /**
     * 设置两个指针，间距为n,如果前一个指针遍历到尾部，则后一个指针的位置即为所求节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null||k==0){
            return null;
        }
        //定义两个指针
        ListNode  first = head;
        ListNode second = head;
        //先遍历k次，获取两个指针的对应的值
        for (int i = 0; i <k-1; i++) {

            if (second.next!=null){
                second = second.next;
            }else {
                return null;
            }

        }
        //两个指针一起向后遍历，如果前一个之前遍历到尾部，则后一个指针的节点即是所求节点
        while (true){

            if (second.next != null){
                first = first.next;
                second = second.next;

            }else {
                return first;
            }
        }


    }

}
