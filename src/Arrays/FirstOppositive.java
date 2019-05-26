package Arrays;

/**
 * created by LMR on 2019/5/20
 */
public class FirstOppositive {//41

    public static void main(String[] args) {

    }
    public int firstMissingPositive(int[] nums) {//[1,1]死循环

        int len = nums.length;
        int temp = 0;
        for (int i = 0; i < len; i++)
        {
            if (nums[i] <= 0 || nums[i] > len)
                continue;
            while (nums[i] > 0 && nums[i] <= len && nums[i] - 1 != i)
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                if (temp == nums[i])
                    break;
            }
        }
        for (int i = 0; i < len; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return len + 1;
    }

    public int firstMissingPositive_y(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] <= 0 || A[i] > A.length || A[A[i]-1] == A[i]) {
                i++;
            } else {
                swap(A, i, A[i]-1);
            }
        }
        i = 0;
        while(i < A.length && A[i] == i+1) {
            i++;
        }
        return i+1;
    }
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
