#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int r = nums.size();
        for (int i =0; i < r - 1; i++) {
            for (int j = i +1; j < r; j++) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }
        return {};
    }

    vector<int> twoSum1(vector<int>& nums, int target) {
        unordered_map<int, int> map;
        int r = nums.size();

        for (int i = 0; i < r; i++) {
            auto iter = map.find(target - nums[i]);
            if (iter != map.end()) {
                return {iter->second, i};
            }
            map.insert(pair<int, int>(nums[i], i));
        }
        return {};
    }
};

int main() {
    vector<int> nums = {2,7,11,15};
    int target = 9;

    Solution s;
    vector<int> arr = s.twoSum1(nums, target);
    if (!arr.empty()) {
        cout<<arr[0]<< " " << arr[1]<<endl;
    }
    return 0;
}
