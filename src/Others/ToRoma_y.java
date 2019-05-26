package Others;

/**
 * created by LMR on 2019/5/18
 */
public class ToRoma_y {

    public static void main(String[] args) {

    }


    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int n = value.length;

        for(int i = n - 1; i >= 0; i--) {
            if(num >= value[i]) {
                int count = num / value[i];
                num %= value[i];
                while(count-- > 0) {
                    sb.append(symbol[i]);
                }
            }
        }

        return sb.toString();
    }
}
