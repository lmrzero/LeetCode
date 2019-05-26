package Arrays;

import java.util.*;

/**
 * created by LMR on 2019/5/21
 */
public class YiWeiZiMu_y {//49

    public static void main(String[] args) {

        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams2(strs);
        for (List list : res)
            System.out.println(list.toString());
    }

    public List<List<String>> groupAnagrams_y(String[] strs) {
        List<List<String>> list = new ArrayList<List<String>>();
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        String key = "";
        for(int i =0; i<len; i++){
            key = strs[i];
            char[] arr = key.toCharArray();
            Arrays.sort(arr);
            key = new String(arr);

            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            } else {
                List<String> res = new ArrayList<>();
                res.add(strs[i]);
                map.put(key, res);
            }
        }

        for(List<String> value: map.values()){
            list.add(value);
        }
        return list;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0)
            return res;
        Node[] ns = new Node[strs.length];
        for (int i = 0; i < strs.length; i++)//获取字符统计数组
        {
            String str = strs[i];
            int counts[] = new int[26];
            for (int j = 0; j < str.length(); j++)
                counts[str.charAt(j) - 'a']++;
            ns[i] = new Node(str, counts);
        }

        Arrays.sort(ns);
        for (Node n : ns)
            System.out.println(n.value);
        List<String> list = new ArrayList<>();
        list.add(ns[0].value);
        for (int i = 1; i < ns.length; i++)
        {
            if (ns[i].equals(ns[i - 1]))
                list.add(ns[i].value);
            else
            {
                res.add(list);
                list = new ArrayList<>();
                list.add(ns[i].value);
            }
        }
        res.add(list);

        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {//32ms

        int [][] counts = new int[strs.length][26];
        Node[] ns = new Node[strs.length];
        for (int i = 0; i < strs.length; i++)//获取字符统计数组
        {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++)
                counts[i][str.charAt(j) - 'a']++;
            ns[i] = new Node(str, counts[i]);
        }
        Map<Node, List<String>> map = new HashMap<Node, List<String>>();
        for (Node n : ns)
        {
            if (map.keySet().contains(n))
            {
                List list = map.get(n);
                list.add(n.value);
            }else
            {
                List<String> list = new ArrayList<>();
                list.add(n.value);
                map.put(n, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List list : map.values())
            res.add(list);

        return res;
    }
    public List<List<String>> groupAnagrams(String[] strs) {//慢 647ms

        int [][] counts = new int[strs.length][26];

        for (int i = 0; i < strs.length; i++)//获取字符统计数组
        {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++)
                counts[i][str.charAt(j) - 'a']++;
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] flag = new boolean[counts.length];
        for (int i = 0; i < counts.length; i++)
        {
            if (flag[i])
                continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < counts.length; j++)
            {
                boolean isCan = true;
                for (int k = 0; k < 26; k++)
                {
                    if (counts[i][k] != counts[j][k])
                    {
                        isCan = false;
                        break;
                    }
                }
                if (isCan)
                {
                    list.add(strs[j]);
                    flag[j] = true;
                }
            }
            res.add(list);
        }

        return res;
    }

}
class Node implements Comparable<Node>{
    String value = "";
    int[] count = new int[26];
    Node(String value, int[] count)
    {
        this.value = value;
        this.count = count;
    }


    @Override
    public boolean equals(Object obj) {
        Node n1 = (Node) obj;
        for (int i = 0; i < 26; i++)
            if (this.count[i] != n1.count[i])
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        String res = "";
        for (int i = 0; i < 26; i++)
            res += count[i];
        return res.hashCode();
    }

    @Override
    public int compareTo(Node o) {
        int len = this.value.length() - o.value.length();
        if (len != 0)
            return len;
        for (int i = 0; i < 26; i++)
            if (this.count[i] > o.count[i])
                return 1;
            else if (this.count[i] < o.count[i])
                return -1;
        return 0;
    }
}
