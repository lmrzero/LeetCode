public class Main {

    public static void main(String[] args) {



        int A[] = {1, 3, 5, 6, 8, 0, 0, 0};
        int B[] = {2, 4, 7};


        int flag1 = 0, flag2 = 0;

        while(flag1 < B.length)
        {
            if(A[flag1] > B[flag2])
            {
                int temp = A[flag1];
                A[flag1] = B[flag2];
                B[flag2] = temp;
            }
            flag1++;
        }

        System.out.println("Hello World!");
    }
}
