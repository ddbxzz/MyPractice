#include <string>
#include <unordered_map>
using namespace std;


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
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
};