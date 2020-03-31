package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }

        return list;



    }
}
