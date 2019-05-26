package Arrays;

/**
 * created by LMR on 2019/5/18
 */
public class TwoArraysMid_h {
    public static void main(String[] args) {//两个有序的数组找中位数  4th

    }

    public static double findMedianSortedArrays(int[] A, int[] B){//将数组分为两个部分，保证两个部分的个数相同，并且左边的数都小于等于右边的数

        int lenA = A.length;
        int lenB = B.length;
        if (lenA > lenB)
        {
            int temp[] = A;
            A = B;
            B = temp;
            lenA = A.length;
            lenB = B.length;
        }

        int iMin = 0, iMax = lenA, half = (lenA + lenB + 1) / 2;
        int i,j;
        while (iMin <= iMax)
        {
            i = (iMin + iMax) / 2;
            j = half - i;
            if (i < iMax && B[j - 1] > A[i])
                iMin = i + 1;
            else if (i > iMin && A[i - 1] > B[j])
                iMax = i - 1;
            else//i满足条件
            {
                //先求出左边部分的最大值
                int maxLeft = 0;
                if (i == 0)
                {
                    maxLeft = B[j - 1];
                }else if (j == 0)
                    maxLeft = A[i - 1];
                else
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                if ((lenA + lenB) % 2 == 1)
                    return maxLeft;

                //求出右边最小值
                int minRight = 0;
                if (i == lenA) { minRight = B[j]; }
                else if (j == lenB) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }

    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
