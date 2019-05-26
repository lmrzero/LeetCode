package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by LMR on 2019/5/18
 */
public class FourNumsSum_y {

    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {//思路一样，不过做了减支处理
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break; // first candidate too large, search finished
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
                continue; // first candidate too small
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // prevents duplicate result in ans list
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break; // second candidate too large
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target)
                    continue; // second candidate too small
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // prevents duplicate results in ans list
                int l = j + 1;
                int h = nums.length - 1;
                while (l < h) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[h];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                        while (l < h && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < h && nums[h] == nums[h - 1]) {
                            h--;
                        }
                        l++;
                        h--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        h--;
                    }
                }
            }
        }
        return list;
    }
}
