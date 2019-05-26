package String;

/**
 * created by LMR on 2019/5/18
 */
public class RegularExpressionMath_h {//10
    /*
    * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
    * */

    public static void main(String[] args) {//   ab   .*  ==>  ..
        String s = "aa";
        String p = ".*";
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p){//*只要确定，即可匹配但后续需要匹配相同的字符

        int lenA = s.length();
        int lenB = p.length();
        boolean mem[][] = new boolean[lenA + 1][lenB + 1];
        mem[0][0] = true;
        for (int i = 0; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (p.charAt( j - 1) == '*'){
                    mem[i][j] = mem[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) =='.') && mem[i - 1][j]) ;
                }else
                    mem[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && mem[i - 1][j - 1];
            }
        }

        /*
        *
         if(p.charAt(j-1) == '*') {
            memory[i][j] = memory[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                    p.charAt(j-2) == '.') && memory[i-1][j]);
        }else {
            memory[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                            && memory[i-1][j-1];
        * */
        return mem[lenA][lenB];
    }
}
