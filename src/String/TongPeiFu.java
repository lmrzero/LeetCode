package String;

/**
 * created by LMR on 2019/5/20
 */
public class TongPeiFu {//44

    public static void main(String[] args) {

        System.out.println(isMatch("acdcb", "a*c?b"));

    }
    public static boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        boolean mem[][] = new boolean[lenS + 1][lenP + 1];
        mem[0][0] = true;
        for (int i = 0; i <= lenS; i++)
            for (int j = 1; j <= lenP; j++)
            {
                if (p.charAt(j - 1) == '*')
                {
                    if (mem[i][j - 1] ||  (i > 0 && (mem[i - 1][j - 1] || mem[i - 1][j])))
                        mem[i][j] = true;
                }else
                {
                    if (i > 0 && (mem[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))))
                        mem[i][j] = true;
                }
                //System.out.println(i + "\t" + j + "\t"+mem[i][j]);
            }
        return mem[lenS][lenP];
    }

    public boolean isMatch_y(String s, String p) {//快
        // 指定双指针，sIndex指向s字符串，pIndex指向p字符串
        int sIndex = 0;
        int pIndex = 0;
        int match = 0;
        int startIndex = -1;
        // 从s字符串作为基准进行比对
        while (sIndex < s.length()){
            // 当pIndex位置的字符和sIndex位置的相同或者pIndex位置的为?时，驱动双指针向前移动一位
            if (pIndex < p.length()  && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            }
            // 当发现'*'时，对p指针直接移动到下一位，将'*'的index传给startIndex处理，同时将s指针传给match指针
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                startIndex = pIndex;
                match = sIndex;
                pIndex++;
            }
            // 当'*'匹配字符时，pIndex始终保持startIndex+1，即'*'的下一位，然后移动match指针和sIndex指针
            // 当出现s和p指针重新匹配时，会被第一个if语句拦截，移动双指针
            // 当移动到一个新的'*'时，在第二个else if重新更新sIndex
            // 可能会出现匹配短了的情况，比如匹配"adcbeb"和"*a*b"，程序会在第一个b就直接跳出，但此时程序检查到后续不匹配的情况
            // 此时重新把startIndex+1赋给pIndex，相当于把第一个b包含进*中进行匹配，然后再出现下一个b时再匹配
            else if (startIndex != -1) {
                pIndex = startIndex + 1;
                match++;
                sIndex = match;
            }
            else
                return false;
        }

        // 检查p剩余的子串
        while (pIndex < p.length() && p.charAt(pIndex) == '*')
            pIndex++;

        return pIndex == p.length();
    }
}
