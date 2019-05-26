package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * created by LMR on 2019/5/21
 */
public class QuanPaiLie {//46

    public static void main(String[] args) {

        QuanPaiLie q = new QuanPaiLie();
        int nums[] = {1,2,3,4};
        q.permute(nums);
        for (List<Integer> list : q.lists)
        {
            System.out.println(list.toString());
        }
    }

    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {

        if (nums.length == 0)
            return lists;

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        lists.add(temp);
        for (int i = 1; i < nums.length; i++)
        {
            int curSize = lists.get(0).size();
            while (lists.size() > 0)
            {
                List list = lists.get(0);
                if (list.size() > curSize)
                    break;
                for (int k = 0; k <= curSize; k++)
                {
                    list.add(k, nums[i]);
                    lists.add(new ArrayList<>(list));
                    list.remove(k);
                }
                lists.remove(0);
            }
        }

        return lists;
    }


    public List<List<Integer>> permute_y(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, nums.length - 1);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int start, int end)
    {
        if (start == end)
        {
            List<Integer> cur = new ArrayList<>();
            for (int n : nums)
                cur.add(n);
            res.add(new ArrayList<Integer>(cur));
        }
        else
        {
            for (int i = start; i <= end; i++)
            {
                swap(nums, start, i);
                helper(res, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
