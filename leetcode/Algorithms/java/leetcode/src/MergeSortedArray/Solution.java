package MergeSortedArray;


import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);

        return;
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];
        System.arraycopy(nums1, 0, tmp, 0, m);

        int p = 0;
        int q = 0;
        int k = 0;
        while (p < m && q < n) {
            nums1[k++] = (nums1[p] < nums2[q]) ? nums1[p++] : nums2[q++];
        }

        if (p < m)
            System.arraycopy(tmp, p, nums1, p + q, m + n - p - q);
        if (q < n)
            System.arraycopy(nums2, q, nums1, p + q, m + n - p - q);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
