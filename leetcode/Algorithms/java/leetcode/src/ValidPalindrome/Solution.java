package ValidPalindrome;

import org.junit.Test;

public class Solution {
    private boolean isDigitAlpha(char c) {
        return Character.isLetterOrDigit(c);
    }
    private boolean isEqual(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (isDigitAlpha(s.charAt(i)) && isDigitAlpha(s.charAt(j))) {
                if (!isEqual(s.charAt(i), s.charAt(j))) {
                    return false;
                }
            }
            if (!isDigitAlpha(s.charAt(i)) && isDigitAlpha(s.charAt(j))) {
                i++;
                continue;
            }
            if (isDigitAlpha(s.charAt(i)) && !isDigitAlpha(s.charAt(j))) {
                j--;
                continue;
            }
            i++;
            j--;
        }

        return true;
    }




    public boolean isPalindrome1(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(isPalindrome(s1));
    }
}
