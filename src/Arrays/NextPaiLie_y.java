package Arrays;

/**
 * created by LMR on 2019/5/20
 */
public class NextPaiLie_y {

    public static void main(String[] args) {

    }


    public void nextPermutation_m(int[] nums) {
        int temp = 0;
        for(int i = nums.length -1; i >= 0; i--)
            for(int j = nums.length -1; j > i; j--)
            {
                //System.out.println("**");
                if(nums[j] > nums[i])
                {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    sort(nums,i + 1, nums.length-1);
                    return;

                }
            }
        sort(nums,0,nums.length-1);
    }

    public static void sort(int nums[], int start, int end) {

        int temp;
        for(int i = 0; i < end - start + 1; i++)
        {
            for(int j = start; j <= end - i -1; j++)
            {
                if(nums[j] > nums[j+1])
                {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {//后面都是递减序列，直接进行reverse操作即可变成递增序列
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
