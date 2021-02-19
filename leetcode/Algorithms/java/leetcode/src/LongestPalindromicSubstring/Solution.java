package LongestPalindromicSubstring;

import org.junit.Test;

public class Solution {

    private boolean isPalindromicString(String s) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int lo = 0;
        int hi = s.length();

        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi - 1)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //Brute Force 超出时间限制
    public String longestPalindrome1(String s) {
        int len = s.length();
        String maxStr = null;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                String tmpStr = s.substring(i, j);
                if (isPalindromicString(tmpStr) && maxLen < tmpStr.length()){
                    maxStr = tmpStr;
                    maxLen = tmpStr.length();
                }
            }
        }
        return maxStr;
    }
    //Brute Force 字符数组可运行
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }




    @Test
    public void test() {
        String s1 = "abcdefghaa";
        String s2 = "a";
        String s3 = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        System.out.println(longestPalindrome2(s3).length());
        System.out.println(s3.length());
    }
}
