#include <string>
#include <vector>
#include <unordered_map>
using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring1(string s) {
        int ans = 0;
        int start = 0;
        unordered_map<char, int> mp;
        int n = s.length();

        for (int i = 0; i < n; i++) 
        {
            if (mp.count(s[i]))
            {
                start = max(start, mp[s[i]] + 1);
            }

            ans = max(ans, i - start +1);
            mp[s[i]] = i;
        }

        return ans;
    }


    int lengthOfLongestSubstring2(string s) {
        vector<int> m(256, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.size(); ++i) {
            left = max(left, m[s[i]]);
            m[s[i]] = i;
            res = max(res, i - left);
        }
        return res;
    }

    int lengthOfLongestSubstring3(string s) {
        int m[256] = {0}, res = 0, left = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (m[s[i]] == 0 || m[s[i]] < left) {
                res = max(res, i - left + 1);
            } else {
                left = m[s[i]];
            }
            m[s[i]] = i + 1;
        }
        return res;
    }
};