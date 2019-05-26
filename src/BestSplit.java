import java.util.Scanner;

public class BestSplit {


    static int MinValue = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int A[] = new int[n];
        for(int i = 0; i < n; i++)
            A[i] = sc.nextInt();

        int preSum[] = new int[n];
        int endSum[] = new int[n];
        if(m == n)
        {
            for(int i : A)
                MinValue = Math.max(i, MinValue);
            System.out.print(MinValue);
        }else
        {
            preSum[0] = A[0];
            for(int i = 1; i < n; i++)
                preSum[i] = preSum[i - 1] + A[i];
            endSum[n-1] = A[n-1];

            for(int i = n - 2; i >= 0; i--)
                endSum[i] = endSum[i + 1] + A[i];

            method(A, preSum, endSum, 0, 0, m, Integer.MIN_VALUE);
            System.out.print(MinValue);
        }
    }

    public static void method(int A[], int[] preSum, int[] endSum, int index, int curCount, int m, int min){

        if(index >= A.length)
            return;
        if(curCount == m)
        {
            MinValue = Math.min(MinValue, Math.max(min, endSum[index]));
        }else
        {
            if(A.length - index < m - curCount)
                return;
            for(int i = index; i < A.length; i++)
            {
                if(i == index)
                {
                    method(A, preSum, endSum, i + 1, curCount + 1, m, Math.max(min, A[i]));
                }else
                {
                    method(A, preSum, endSum, i + 1, curCount + 1, m, Math.max(min, preSum[i] - preSum[index] + A[index]));
                }

            }
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            String temp = in.nextLine();
            int[] A = new int[n];
            int sum = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                A[i] = in.nextInt();
                sum = sum + A[i];
                if (max < A[i])
                    max = A[i];
            }
            System.out.println(BinarySearch(A,max,sum,m,n));
        }
    }
    public static int BinarySearch(int[] A, int left, int right, int m, int n){
        int mid = 0;
        while (left<right){
            mid = left +(right-left)/2;
            if (Judge(A,mid,m,n)==1){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return left;
    }
    public static int Judge(int[] A, int mid,int m, int n){
        int cnt = 0;
        int sum = 0;
        for (int i=0; i<n; i++){
            if (sum+A[i]>mid){
                sum = A[i];
                cnt++;
                if (cnt>m-1){
                    return 0;
                }
            }
            else {
                sum += A[i];
            }
        }
        return 1;
    }
}
//