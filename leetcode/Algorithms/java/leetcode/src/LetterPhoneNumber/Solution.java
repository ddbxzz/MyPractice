package LetterPhoneNumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    //DFS
    String[] strArray = {null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }

        DFS(res, 0, digits, new StringBuilder());
        return res;
    }

    private void DFS(List<String> ans, int index, String str, StringBuilder sb) {
        if (index == str.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = strArray[str.charAt(index) - '0'];
        int cnt = letters.length();
        for (int i = 0; i < cnt; i++) {
            sb.append(letters.charAt(i));
            DFS(ans, index + 1, str, sb);
            sb.deleteCharAt(index);
        }
    }

    @Test
    public void test() {
        String digits = "23";
        //letterCombinations(digits);
        System.out.println(letterCombinations(digits));
    }
}
