/**
 * 暴力解法
 */
#include <iostream>
#include <vector>
#include "ContainerUtils.h"

using namespace std;

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        vector<int> ans(2, 0);
        for (unsigned int i = 0; i < nums.size() - 1; i++)
        {
            for (unsigned int j = i + 1; j < nums.size(); j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
};

int main(int argc, char const *argv[])
{
    Solution solu;
    vector<int> nums{2, 7, 11, 15};
    int target = 9;
    vector<int> ans = solu.twoSum(nums, target);
    fany::printVector(ans);

    return 0;
}
