package Others;

/**
 * created by LMR on 2019/5/20
 */
public class BaoShu {

    public static void main(String[] args) {
        countAndSay(10);
    }

    public static String countAndSay(int n) {

        if (n == 1)
            return "1";
        String pre = "1";
        for (int i = 2; i <= n; i++)
        {
            String cur = "";
            int counr = 1;
            for (int j = 1; j < pre.length(); j++)
            {
                if (j > 0 && pre.charAt(j) == pre.charAt(j - 1))
                    counr++;
                else
                {
                    int value = pre.charAt(j - 1) - '0';
                    cur += counr + ""+value;
                    counr = 1;
                }
            }
            int value = pre.charAt(pre.length() - 1) - '0';
            cur += counr + ""+ value;
            pre = cur;
            //System.out.println(cur);
        }
       // System.out.println(pre);


        return pre;
    }

    public String countAndSay_y(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        for (int i = 2; i <= n; i++) {
            String prev = dp[i - 1];
            int l = 0, r = 0;
            StringBuilder sb = new StringBuilder();
            while (l < prev.length()) {
                while (++r < prev.length() && prev.charAt(r) == prev.charAt(l));//使用while循环找出相同得字符
                sb.append(r - l).append(prev.charAt(l));
                l = r;
            }
            dp[i] = sb.toString();
        }
        return dp[n];
    }
}
