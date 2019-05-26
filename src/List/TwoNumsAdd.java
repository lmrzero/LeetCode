package List;

/**
 * created by LMR on 2019/5/17
 */
public class TwoNumsAdd {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
       // l2.next = new ListNode(9);
        TwoNumsAdd two = new TwoNumsAdd();
        System.out.println(two.addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode move1 = l1;
        ListNode move2 = l2;
        ListNode pre = move1;
        int jw = 0;
        while (move1 != null && move2 != null)
        {
            int val = move1.val + move2.val + jw;
            if (val >= 10)
                jw = 1;
            else
                jw = 0;
            move1.val = val % 10;
            pre = move1;
            move1 = move1.next;
            move2 = move2.next;
        }
        if (move1 != null)
        {
            if(jw == 1) {
                while (move1 != null && jw == 1) {
                    int val = move1.val + jw;
                    if (val >= 10)
                        jw = 1;
                    else
                        jw = 0;
                    move1.val = val % 10;
                    pre = move1;
                    move1 = move1.next;
                }
            }
        }

        if (move2 != null)
        {
            pre .next = move2;
            if (jw == 1)
            {
                while (move2 != null && jw == 1) {
                    int val = move2.val + jw;
                    if (val >= 10)
                        jw = 1;
                    else
                        jw = 0;
                    move2.val = val % 10;
                    pre = move2;
                    move2 = move2.next;
                }
            }
        }

        //防止两个数位数相同但是最后有进位
        if (jw == 1)
            pre.next = new ListNode(1);



        return l1;
    }

}
