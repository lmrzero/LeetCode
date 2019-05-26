package List;

/**
 * created by LMR on 2019/5/17
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int val)
    {
        this.val = val;
    }

    @Override
    public String toString() {
        if (next != null)
            return this.val + "->" + next.toString();
        else
            return  this.val + "";
    }
}
