package Arrays;

import java.util.Arrays;

/**
 * created by LMR on 2019/5/20
 */
public class JumpGame_y {//45

    public static void main(String[] args) {

        int nums[] = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {//超时

        int mem[] = new int[nums.length];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i > 0 && nums[i] < nums[i - 1])//加上该条语句，防止递减序列的超时
                continue;
            for (int j = 1; j <= nums[i]; j++)
            {
                if (i + j < nums.length)
                    mem[i +j] = Math.min(mem[i] + 1, mem[i + j]);
                else
                    break;;
            }
        }

        return mem[nums.length - 1];
    }

    public int jump_y(int[] nums) {//每走一步所能走的最远路程
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int n = nums.length;

        int step = 0, curIndex = 0, i = 0, nextIndex = 0;

        while (curIndex - i + 1 > 0) {
            step++;
            for (; i <= curIndex; i++) {
                nextIndex = Math.max(nextIndex, nums[i] + i);//最远的位置？
                if (nextIndex >= n - 1) return step;
            }
            curIndex = nextIndex;
        }
        return 0;
    }
}
