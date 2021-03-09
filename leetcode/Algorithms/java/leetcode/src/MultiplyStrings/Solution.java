package MultiplyStrings;

public class Solution {
    //直接传统竖式
    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        String result = "0";
        for (int i = len2; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            for (int j = len2; j > i; j--) {
                tmp.append(0);
            }
            int y = num2.charAt(i) - '0';
            int add = 0;
            for (int j = len1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int sum = x * y + add;
                tmp.append(sum % 10);
                add = sum / 10;
            }
            if (add != 0) {
                tmp.append(add);
            }
            result = addString(result, tmp.reverse().toString());
        }
        return result;
    }

    //优化竖式
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x= num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = x * y + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        int idx = (res[0] == 0) ? 1 : 0;
        StringBuilder result = new StringBuilder();
        while (idx < res.length) {
            result.append(res[idx++]);
        }

        return result.toString();
    }

    //fft
    public String multiply3(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        return null;
    }

    private String addString(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int add = 0;

        StringBuilder res = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || add != 0) {
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int sum = x + y + add;
            res.append(sum % 10);
            add = sum / 10;
            len1--;
            len2--;
        }
        res.reverse();
        return res.toString();
    }
}
