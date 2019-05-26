package String;

/**
 * created by LMR on 2019/5/18
 */
public class MaxHuiWen_y {

    public static void main(String[] args) {//最长回文字符串 5th

        System.out.println(longestPalindrome("abbacbbca"));
    }

    public static int longestPalindrome(String s){

        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        char[] cs = s.toCharArray();
        String res = "";
        for (int i = 1; i <= len; i++)
        {
            for (int j = 0; j <= len - i; j++)
            {
                if (i == 1)
                    isPalindrome[j][j] = true;
                else if(i == 2)
                    isPalindrome[j][j + 1] = cs[j] == cs[j + 1];
                else
                {
                    isPalindrome[j][j + i - 1] = cs[j] == cs[j + i - 1] && isPalindrome[j + 1][j + i - 2];
                }
                if (isPalindrome[j][j + i - 1])
                    res = s.substring(j, j + i);
            }
        }


        System.out.println(res);
        return res.length();
    }

    public String longestPalindrome1(String s) {//以i为中心的两搜索
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = find(c, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    private int find(char[] c, int low, int[] range) {
        int max = c.length - 1;
        int high = low;
        while (high < max && c[high + 1] == c[low]) {//找到中间重复的子串
            high++;
        }
        int result = high;
        while (low > 0 && high < max && c[low - 1] == c[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return result;
    }
}
