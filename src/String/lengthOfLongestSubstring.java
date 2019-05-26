package String;

import java.util.ArrayList;
import java.util.List;

/**
 * created by LMR on 2019/5/17
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {//不仅仅是字母

        System.out.println(soultion("pwwkew"));
    }

    public static int soultion(String s){

        if (s.length() == 0)
            return 0;
        int mem[] = new int[96];
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (i == 0)
            {
                max = 1;
                mem[s.charAt(i)- 32] = 1;
            }else
            {
                if (mem[s.charAt(i)-32] != 0)
                {
                    start = Math.max(mem[s.charAt(i) - 32], start);
                }
                max = Math.max(max, i - start + 1);
                mem[s.charAt(i) - 32] = i + 1;
            }
        }

        return max;
    }
}
