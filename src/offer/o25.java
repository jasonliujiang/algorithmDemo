package offer;

import sun.security.util.Password;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class o25 {
    //递归版本
    public ListNode MergeRe(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode pMergedHead = null;
        if (list1.val>list2.val){
            pMergedHead = list2;
            pMergedHead.next = MergeRe(list1,list2.next);
            //return list1;
        }else {
            pMergedHead = list1;
            pMergedHead.next = MergeRe(list1.next,list2);
            //return list2;
        }

        return pMergedHead;
    }

    //非递归版本
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(-1);
        result.next = null;
        ListNode root = result;
        while (list1!=null&&list2!=null){
            if (list1.val>=list2.val){
                result.next = list2;
                result = list2; //result.next
                list2 = list2.next;
            }else {
                result.next = list1;
                result = list1;  //result.next
                list1 = list1.next;
            }
        }
        if (list1 == null){
            result.next = list2;
        }else {
            result.next = list1;
        }

        return root.next;

    }
}
