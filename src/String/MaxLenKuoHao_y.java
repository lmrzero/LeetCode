package String;

/**
 * created by LMR on 2019/5/20
 */
public class MaxLenKuoHao_y
{

    public static void main(String[] args) {


        System.out.println(maxLen("(()(((()"));
    }

    public static int longestValidParentheses_dp(String s){//动态规划的思想

        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public int longestValidParentheses(String s) {//从左边往右边走，，从右边往左边走
        int left = 0, right = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
            if (right > left) {
                left = right = 0;
            }

        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, left * 2);
            }
            if (right < left) {
                left = right = 0;
            }

        }
        return result;
    }

    public static int maxLen(String s){//错误

        int leftSize = 0;
        int rightSize = 0;
        int len = s.length();
        int start = 0;
        int max = 0;
        int end = -1;
        int cur = 0;
        while (start < len)
        {
            if (s.charAt(start) == '(')
            {
                leftSize++;
            }else
            {
                rightSize++;
                if (rightSize == leftSize)
                {
                    if (start - rightSize*2 == end)
                        cur += leftSize*2;
                    else
                    {
                        max = Math.max(max, cur);
                        cur = leftSize*2;
                    }
                    end = start;
                    leftSize = 0;
                    rightSize = 0;
                }else if (rightSize > leftSize)
                {
                    rightSize = 0;
                }
            }
            System.out.println(leftSize+"\t"+rightSize+"\t"+cur+"\t"+max);
            start++;
        }
        int last = Math.min(leftSize,rightSize) * 2;
        max = Math.max(last, max);
        max = Math.max(max, cur);
        return max;
    }
}
