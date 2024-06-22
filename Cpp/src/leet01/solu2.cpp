/**
 * 哈希表解法
 */
#include <iostream>
#include <vector>
#include <unordered_map>
#include "ContainerUtils.h"

using namespace std;

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        vector<int> ans(2, 0);
        unordered_map<int, int> htable;
        for (unsigned int i = 0; i < nums.size(); i++)
        {
            if (htable.find(target - nums[i]) != htable.end())
            {
                ans[0] = htable.find(target - nums[i])->second;
                ans[1] = i;
                return ans;
            }
            htable.insert({nums[i], i});
        }
        return ans;
    }
};

int main(int argc, char const *argv[])
{
    Solution solu;
    // vector<int> nums{2, 7, 11, 15};
    // int target = 9;
    vector<int> nums{3, 2, 4};
    int target = 6;
    vector<int> ans = solu.twoSum(nums, target);
    fany::printVector(ans);

    return 0;
}
