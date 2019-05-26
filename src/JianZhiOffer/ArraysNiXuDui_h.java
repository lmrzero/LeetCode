package JianZhiOffer;

/**
 * created by LMR on 2019/5/16
 */
public class ArraysNiXuDui_h {

    public static void main(String[] args) {


        int nuns[] = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        ArraysNiXuDui_h as = new ArraysNiXuDui_h();
        System.out.println(as.InversePairs(nuns));
        System.out.println(nuns.length * nuns.length);
        int sum = 0;
        for (int i = 0; i < nuns.length; i++)
            for (int j = i; j < nuns.length; j++)
            {
                if (nuns[i] > nuns[j])
                {
                    sum = (sum + 1)%1000000007;
                }
            }

        System.out.println(sum);
    }



    public int InversePairs(int [] array) {
        int length = array.length;
        if(length <=1)
            return 0;
        else
            return gb(array,0,length-1)%1000000007;
    }

    public int gb(int array[],int low, int high){

        if(low < high)
        {
            int mid = (low + high)/2;
            int left = gb(array,low,mid)%1000000007;
            int right = gb(array,mid+1,high)%1000000007;
            int merg = merge(array,low,high)%1000000007;
            return (left + right + merg)%1000000007;
        }
        return 0;
    }

    public int merge(int[] array, int low, int high){
        int [] temp = new int[high - low +1];
        int mid = (low + high) / 2;
        int k = 0,i = low, j = mid+1,sum = 0;
        while(i <= mid && j <= high)
        {
            if(array[i] > array[j])
            {
                sum += mid -i+1;
                if(sum >= 1000000007)//数值过大求余
                {
                    sum %= 1000000007;
                }
                temp[k++] = array[j++];
            }else
            {
                temp[k++] = array[i++];
            }
        }
        while(i <= mid)
            temp[k++] = array[i++];
        while(j <= high)
            temp[k++] = array[j++];
        for(int m = 0; m < temp.length -1; m++)
            array[low+m] = temp[m];
        return sum;

    }
}
