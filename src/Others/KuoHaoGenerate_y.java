package Others;

import java.util.ArrayList;
import java.util.List;

/**
 * created by LMR on 2019/5/18
 */
public class KuoHaoGenerate_y {

    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)//先生成左括号，，每次产生一个左括号之后才能产生一个右括号
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
