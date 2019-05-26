import java.util.ArrayList;
import java.util.List;

public class Yuan {
    static String pre = "xi:eststo:reg rd power Ins_Id powerIns_Id lnsize lev ";
    static String end = "i.year i.ind,cluster(code)";
    public static void main(String[] args) {

        String [] value = {"growth", "cf", "oc", "roe", "roa", "soe"};

        for(int i = 1; i < 8; i++)
        {
                method(value, 0, 0, i, new ArrayList<>());
        }
    }


    public static void method(String [] values, int cur, int index, int target, List<String> list){

        if(cur == target)
        {
            System.out.print(pre);
            for(String s : list)
                System.out.print(s+" ");
            System.out.println(end);
        }else
        {
            for(int i = index; i < values.length; i++)
            {
                list.add(values[i]);
                method(values, cur + 1, i + 1, target, list);
                list.remove(list.size()-1);
            }
        }

    }
}
