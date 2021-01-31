package LengthLastWord;

import org.junit.Test;

public class Solution {
    public int lengthOfLastWord1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String[] strArray = s.split(" ");
        if (strArray.length == 0) {
            return 0;
        }

        return strArray[strArray.length -1].length();
    }

    public int lengthOfLastWord2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }

    @Test
    public void test() {
        String s = "    ";
        String s1 = "hello";
        String s2 = "hello wer";
        System.out.println(lengthOfLastWord2(s2));
    }
}
