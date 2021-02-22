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

    //dynamic programming
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

/*        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }*/

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //dp[i][j] = (charArray[i] == charArray[j]) && (j - i < 3 || dp[i + 1][j - 1]);
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                }
                else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    begin =i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    //中心扩散法
    public String longestPalindrome4(String s) {
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;
        int len;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }


        return s.substring(start, end + 1);
    }

    private int expandCenter(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }
        return hi - lo - 1;
    }

    //Manacher 算法
    public String longestPalindrome5(String s) {
        return null;
    }

    @Test
    public void test() {
        String s1 = "abcdefghaa";
        String s2 = "a";
        String s3 = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        String s4 = "abcbadd";
        System.out.println(longestPalindrome3(s4));
        System.out.println(s3.length());
    }
}
