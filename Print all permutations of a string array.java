import java.util.*;
public class Solution {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        return helper("",s);
    }
    static List<String> helper(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++) {
            String a = p.substring(0,i);
            String b = p.substring(i);
            list.addAll(helper(a+ch+b,up.substring(1)));
        }
        return list;
    }
}
