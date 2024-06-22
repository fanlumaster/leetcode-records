#include "ContainerUtils.h"

class Solution {
  public:
    vector<vector<int>> permute(vector<int> &nums) {
        vector<vector<int>> res;
        if (nums.size() == 1) {
            res.push_back({nums[0]});
        } else {
            vector<int> partsExcludeFirstElement = vector<int>(nums.begin() + 1, nums.end());
            for (vector<int> &perm : permute(partsExcludeFirstElement)) {
                for (int i = 0; i < perm.size() + 1; i++) {
                    vector<int> cur;
                    vector<int> firstPart = vector<int>(perm.begin(), perm.begin() + i);
                    vector<int> secondPart = {nums[0]};
                    vector<int> thirdPart = vector<int>(perm.begin() + i, perm.end());
                    cur.insert(cur.end(), firstPart.begin(), firstPart.end());
                    cur.insert(cur.end(), secondPart.begin(), secondPart.end());
                    cur.insert(cur.end(), thirdPart.begin(), thirdPart.end());
                    res.push_back(cur);
                }
            }
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    Solution solu;
    // case1
    vector<int> nums = {1, 2, 3};
    // vector<int> nums = {1};
    auto res = solu.permute(nums);
    for (vector<int> &each : res) {
        fany::printVector(each);
    }
    return 0;
}
