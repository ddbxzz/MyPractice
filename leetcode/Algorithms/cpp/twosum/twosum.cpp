#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int l = 0; 
        int r = nums.size() - 1;
        for (int i =0; i < r - 1; i++) {
            for (int j = i +1; j < r; j++) {
                if (nums[i] + nums[j] == target) {
                    return {nums[i], nums[j]};
                }
            }
        }
        return {};
    }
};

int main() {
    vector<int> nums = {2,7,11,15};
    int target = 9;

    Solution s;
    vector<int> arr = s.twoSum(nums, target);
    if (!arr.empty()) {
        cout<<arr[0]<< " " << arr[1]<<endl;
    }
    return 0;
}
