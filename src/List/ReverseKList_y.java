package List;

/**
 * created by LMR on 2019/5/18
 */
public class ReverseKList_y {

    public static void main(String[] args) {

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, next = head;
        for (int i = 1; cur != null; i++) {
            if (i % k == 0) {
                pre = reverseOneGroup(pre, cur.next);//此时pre刚好为翻转之后下一个小组的前一个结点
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverseOneGroup(ListNode pre, ListNode next) {//pre为选择子链表的前一个结点， next为最后一个结点的下一个结点
        ListNode p = pre.next, q = p.next;
        while (q != next) {
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
            q = p.next;
        }
        return p;
    }
}
