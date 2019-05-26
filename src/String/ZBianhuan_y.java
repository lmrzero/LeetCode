package String;

/**
 * created by LMR on 2019/5/18
 */
public class ZBianhuan_y {
    public static void main(String[] args) {

    }

    public static void convert(String s, int numsRows){

        StringBuffer str = new StringBuffer();
        str.append(s.charAt(0));
       // String res = s.charAt(0) + "";
        int gap = numsRows - 2;
        int lag = (numsRows - 1) * 2;
        int len = s.length();

    }

    public String convert1(String s, int numRows) {
        //字符串转化成数组
        char[] c = s.toCharArray();
        //创建字符串数组
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();
        int i = 0;
        int len = c.length;
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++)
                sb[idx].append(c[i++]);
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--)
                sb[idx].append(c[i++]);
        }
        //拼接所有字符串
        for(int idx = 1;idx < numRows;idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}
