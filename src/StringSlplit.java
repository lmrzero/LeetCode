public class StringSlplit {


    public static void main(String[] args) {


        String str = "";
        StringSlplit.method("ababbacadefgdehijhklij");
    }

    public static void method(String str){
        if(str.length() <= 1)
        {
            System.out.print(str.length());
            return;
        }
        int temp [][] = new int[26][2];
        for(int i = 0; i < 26; i++)
            temp[i][0] = -1;
        char[] cs = str.toCharArray();
        for(int i = 0; i < cs.length; i++)
        {
            //System.out.println(cs[i] - 'a');
            if(temp[cs[i] - 'a'][0] == -1)
            {
                temp[cs[i] - 'a'][0] = i;
                temp[cs[i] - 'a'][1] = i;
            }else
                temp[cs[i] - 'a'][1] = i;
        }

        int x1 = 0, x2 = 0;
        for(int i = 0; i < 26; i++)
            for(int j = 0; j < 26 - i - 1; j++)
            {
                if(temp[j][0] > temp[j+1][0])
                {
                    x1 = temp[j][0];
                    x2 = temp[j][1];
                    temp[j][0] = temp[j+1][0];
                    temp[j][1] = temp[j+1][1];
                    temp[j+1][0] = x1;
                    temp[j+1][1] = x2;
                }
            }
        /*for(int[] i : temp)
            System.out.println(i[0]+"\t"+i[1]);*/

        int start = -1, end = -1;
        for(int i = 0; i < 26; i++)
        {
            if(temp[i][0] == -1)
                continue;
            if(end ==  -1)
            {
                start = temp[i][0];
                end = temp[i][1];
            }else if(end < temp[i][0])
            {
                System.out.print(end - start + 1 + " ");
                start = temp[i][0];
                end = temp[i][1];
            }
            else
                end = Math.max(temp[i][1],end);
        }
        System.out.print(end - start + 1);

    }
}
