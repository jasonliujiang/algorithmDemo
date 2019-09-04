package offer;

import java.util.ArrayList;
import java.util.List;

/*
* 从尾到头打印链表
* */

/*
* //非递归，创建一个列表遍历后每次从头插入
        List<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while (tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
* */
public class o3 {
    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;

    }
}
