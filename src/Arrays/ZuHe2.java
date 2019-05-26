package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by LMR on 2019/5/20
 */
public class ZuHe2 {//40th

    public static void main(String[] args) {

    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<>(),0);
        return res;
    }

    public void dfs(int[] data, int target, List<Integer> list, int index){

        for (int i = index; i < data.length; i++)
        {
            if (i == index || data[i] != data[i - 1])
            {
                if (data[i] == target)
                {
                    list.add(data[i]);
                    res.add(new ArrayList<>(list));
                    list.remove(list.size() - 1);
                    return;
                }
                if (data[i] < target)
                {
                    list.add(data[i]);
                    dfs(data,target - data[i],list,i + 1);
                    list.remove(list.size() - 1);
                }else
                    return;
            }
        }
    }
}
