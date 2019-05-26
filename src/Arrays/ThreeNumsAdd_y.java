package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by LMR on 2019/5/18
 */
public class ThreeNumsAdd_y {
    public static void main(String[] args) {

    }

     List<List<Integer>> res= new ArrayList<>();
    public  List<List<Integer>> threeSum(int[] nums){

        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, 0);
        return res;
    }

    public  void dfs(int nums[] , List<Integer> list, int index, int sum){//超时？？
        if (list.size() == 3 && sum == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        if (list.size() >= 3)
            return;

        for (int i = index; i <nums.length; i++)
        {
            if (sum + nums[index] > 0)
                break;
            list.add(nums[i]);
            if (i == 0 || nums[i] != nums[i - 1])
                dfs(nums, list, i + 1, sum + nums[index]);
             list.remove(list.size() - 1);
        }

    }

    public static List<List<Integer>> method(int nums[]){
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;//重复
            int target = 0 - nums[k]; //fit一个
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) ++i;
                    while (i < j && nums[j] == nums[j - 1]) --j;
                    ++i;
                    --j;
                } else if (nums[i] + nums[j] < target) ++i;
                else --j;
            }
        }
        return result;
    }
}
