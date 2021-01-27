package ImplementstrStr;

import org.junit.Test;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }

        int lenhay = haystack.length();
        int lennee = needle.length();

        if (lennee > lenhay) {
            return -1;
        }

        char ch = needle.charAt(0);
        int index = -1;
        for (int i = 0; i < lenhay; i++) {
            if (haystack.charAt(i) != ch) {
                continue;
            }
            if (lenhay - i < lennee) {
                return -1;
            }
            index = i;
            i++;
            for (int j = 1; j < lennee; j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    i = index;
                    index = -1;
                    break;
                }
                i++;
            }

            if (index != -1) {
                break;
            }
        }

        return index;
    }

    public int strStr1(String haystack, String needle) {
        int L = haystack.length();
        int N = needle.length();

        for (int i = 0; i < L - N + 1; i++) {
            if (haystack.substring(i, i + N).equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }
//KMP
// Rabin Karp
    @Test
    public void test() {
        assert (strStr("hello", "ll") == 2);
        assert (strStr("aaahello", "llww") == -1);
        assert (strStr("mississippi", "issip") == 4);
    }
}
