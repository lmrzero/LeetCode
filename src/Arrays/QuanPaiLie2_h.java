package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by LMR on 2019/5/21
 */
public class QuanPaiLie2_h {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1};
        QuanPaiLie2_h q = new QuanPaiLie2_h();
        q.permuteUnique_my(nums);
        for (List<Integer> list : q.lists)
        {
            System.out.println(list.toString());
        }
    }


    public List<List<Integer>> permuteUnique_y(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permute(lists, nums, 0);
        return lists;
    }

    private  void permute(List<List<Integer>> lists, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            lists.add(list);
            return;
        }
        //处理数据start后的元素
        for (int i = start; i < nums.length; i++) {
            if (!canSwap(nums, start, i)) {//判断前面是否有相同的数字
                continue;
            }
            //把当前要处理的元素换到最前面
            swap(nums, i, start);
            permute(lists, nums, start + 1);
            //恢复交换元素
            swap(nums, start, i);

        }
    }

    private static boolean canSwap(int nums[], int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

  /*  private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }*/




    List<List<Integer>> lists = new ArrayList<List<Integer>>();







    public List<List<Integer>> permuteUnique_my(int[] nums){//not

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
                List<Integer> list = lists.get(0);
                if (list.size() > curSize)
                    break;
                for (int k = 0; k <= curSize; k++)
                {
                    if (k < curSize && (nums[i] == list.get(k).intValue() || (k > 0 && list.get(k) == list.get(k - 1))))
                        continue;
                    list.add(k, nums[i]);
                    lists.add(new ArrayList<>(list));
                    list.remove(k);
                }
                lists.remove(0);
            }
        }

        return lists;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);//排序
        method(nums, 0, nums.length - 1);
        return lists;
    }

    public void method(int[] nums, int left, int right){

        if (left == right)
        {
            List<Integer> list = new ArrayList<Integer>();
            for(int i : nums)
                list.add(i);
            lists.add(list);
        }else {
            for (int i = left; i <= right; i++) {
                if (i != left && (nums[i-1] == nums[i] || nums[left] == nums[i])) continue;  //去重  left == i ??
                if(i > left +1 && nums[i] == nums[i-2]) continue;
                swap(nums,left,i);
                method(nums, left + 1, right);
               swap(nums, left, i);
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
