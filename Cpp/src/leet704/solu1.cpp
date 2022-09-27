#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        int left = 0;
        int right = nums.size() - 1; // notice here
        while (left <= right)        // and here <=
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else if (nums[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }
};

int main(int argc, char const *argv[])
{
    Solution solu;
    vector<int> nums{-1, 0, 3, 5, 9, 12};
    int target = 9;
    int res = solu.search(nums, target);
    cout << res << endl;

    nums.clear();
    nums.shrink_to_fit();
    nums.insert(nums.end(), {-1, 0, 3, 5, 9, 12});
    target = 2;
    res = solu.search(nums, target);
    cout << res << endl;
    target = 5;
    res = solu.search(nums, target);
    cout << res << endl;

    return 0;
}
