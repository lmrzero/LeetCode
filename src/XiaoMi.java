import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class XiaoMi {


    static boolean isCan = false;
    static List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) {//?????????????题目要求最多出现一次
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int prices[] = new int[N];
        for(int i = 0; i < N; i++)
            prices[i] = sc.nextInt();
        int M = sc.nextInt();

        Arrays.sort(prices);

        method(prices, 0, M);
        if(!isCan)
            System.out.print(0);
        else
            System.out.print(1);

    }//200  599
//8072 5352 2223 6876 1176 7854 1763 7453 620 6455 4263 1500 7326 1515 998 547 8007 6451 6452 459 9436 167 7293 5752 4854 3534 8519 3973 9567 2223 8026 5497 4219 8853 8016 654 2485 7781 6221 4009 613 2505 6893 1956 692 1688 9159 6342 8326 1659 7040 7879 8615 761 2197 3905 8220 5339 9977 9193 8159 295 377 6439 4486 5080 5624 7495 6988 9139 8464 6286 1990 1954 5020 8611 5008 1132 7056 976 6285 4300 8214 7933 5191 8436 5652 9728 4521 2097 6468 7748 1063 3065 6718 2943 4586 3604 9320 7320 7275 4140 9804 2361 3312 6740 8978 8778 2115 2889 1474 3250 7932 6275 4465 170 7922 6424 5723 5593 2158 6431 1110 1591 2294 9859 3372 7869 2229 8504 4258 7202 7553 4826 6304 3342 7441 6190 3042 2138 9583 2799 2923 7789 4547 3203 6247 16 4548 482 1756 969 2234 3236 8867 2499 5966 5906 3329 3268 8743 6739 2834 739 2607 383 7788 5834 4073 8545 4551 7857 6916 7739 2382 5328 594 2027 8468 3469 1886 9269 1779 1138 8320 6738 8965 7510 8814 5628 5935 1314 8163 8920 1834 1772 7685 2304 4223 7311
    public static void method(int prices[], int sum, int target){

        if(sum == target)
        {
            isCan = true;
            return;
        }else if(sum > target)
            return;
        if(list.contains(sum))
            return;
        else
            list.add(sum);
        for(int i = 0; i < prices.length; i++)
        {
            if(isCan)
                break;
            if(sum + prices[i] < target)
                method(prices, sum + prices[i], target);
            else
                break;
        }
    }

    public static int bag(int []weight,int n,int sum){
        int dp[]=new int[sum+1];
        dp[0]=1;
        int i,j;
        for(i=0;i<n;i++){
            for(j=sum;j>=weight[i];j--){
                dp[j]=dp[j-weight[i]]+dp[j];
            }
        }
        return dp[sum]!=0?1: 0;
    }
    public static void main1(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int i,j;
        int arr[]=new int[n];
        for(i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int sum=s.nextInt();
        System.out.println(bag(arr,n,sum));
    }
}
