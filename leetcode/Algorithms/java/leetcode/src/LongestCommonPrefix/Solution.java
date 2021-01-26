package LongestCommonPrefix;

import org.junit.Test;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();

        int len = strs.length;
        if (len == 0) {
            return res.toString();
        }

        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i < strs[j].length() && tmp == strs[j].charAt(i)) {
                    continue;
                }
                else {
                    return res.toString();
                }
            }
            res.append(str.charAt(i));
        }

        return res.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            for(; j < ans.length() && j < strs[i].length(); j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }


    @Test
    public void test() {
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"ab","a"};
        assert ("fl".equals(longestCommonPrefix(strs1)));
        assert ("".equals(longestCommonPrefix(strs2)));
        assert ("a".equals(longestCommonPrefix(strs3)));
    }
}
