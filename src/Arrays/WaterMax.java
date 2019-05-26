package Arrays;

/**
 * created by LMR on 2019/5/18
 */
public class WaterMax {
    public static void main(String[] args) {
            int nums[] = {1,8,6,2,5,4,8,3,7};
            solution(nums);
    }

    public static int solution(int height[])
    {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right)
        {
            int cur = Math.min(height[left], height[right]);
            max = Math.max(max, cur * (right - left));
            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        System.out.println(max);
        return max;
    }
}
