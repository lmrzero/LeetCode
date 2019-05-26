package Arrays;

/**
 * created by LMR on 2019/5/20
 */
public class JieYuShui_y {//42

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
/*一次遍历从前往后，
*
* */

        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];
        for (int i = height.length - 2; i >= 0; i++)
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);

        for (int i = 1; i < height.length; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);

        int water = 0;
        for (int i = 0; i < height.length; i++)
        {
            int level = Math.min(maxLeft[i], maxRight[i]);
            water += Math.max(0, height[i] - level);
        }
        return water;
    }

    public int trap_y(int[] height) {//两个指针之间无论存在什么样的情况，保证当前坐标下所能接的雨水
        if (height.length <= 1) return 0;
        // start 2 pointers
        int left = 0; int right = height.length-1;
        int sum = 0;
        while (left < right) {
            int max = 0;
            // keep advancing left while height is less/equal to right pointer && we havent reached the right pointer
            while (left < right && height[left] <= height[right]) {
                max = Math.max(max, height[left]);//左边最大值减去当前的值，因为右边肯定大于左边，所以不需要考虑右边
                sum += max - height[left];
                left++;
            }
            max = 0;
            // reset max, and do the same while the right height is less than left height
            while (left < right && height[right] < height[left]) {
                max = Math.max(max, height[right]);
                sum += max - height[right];
                right--;
            }
        }
        return sum;
    }
}
