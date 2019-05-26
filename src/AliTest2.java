import java.util.Scanner;

public class AliTest2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int sum = 0;

        for(int i = 1; i < K; i++)
        {
            sum += fun(M, i) * fun(N, K - i);
            System.out.println(fun(M, i)+"\t"+fun(N, K - i));
        }
        System.out.print(sum);
    }


    static int fun(int m, int n) {//m个苹果放在n个盘子中共有几种方法
        if(m==0 || n==1)
            return 1;
        if(n>m)
            return fun(m,m);
        else
            return fun(m,n-1)+fun(m-n,n);
    }
}


