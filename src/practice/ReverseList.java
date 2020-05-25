package practice;


/**
 * 输入一个链表，反转第m到n个节点。
 */
public class ReverseList {
    public class o15 {
        public ListNode ReverseList(ListNode head,int m,int n) {
            //判断特殊边界值
            if (head == null){
                return null;
            }
            if (head.next == null){
                return head;
            }
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode node = preHead;

            for (int i = 0; i < m-1; i++) {
                node = node.next;
            }

            ListNode pre = node;
            ListNode listNodeM  = node.next;
            ListNode nextNode = null;


            for (int i = m;i<n;i++){
                nextNode = listNodeM.next;
                listNodeM.next = nextNode.next;
                nextNode.next = pre.next;
                pre.next = nextNode;
            }
            return preHead.next;
        }
    }
}
