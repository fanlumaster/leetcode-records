// to make the time complexity equals to O(log(m+m))
// we need to dichotomy
#include <iostream>
#include <vector>

using namespace std;

class Solution {
  public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if ((m + n) % 2 == 1) {
            return findKthSortedArrays(nums1, nums2, (m + n + 1) / 2);
        } else {
            int left = findKthSortedArrays(nums1, nums2, (m + n) / 2);
            int right = findKthSortedArrays(nums1, nums2, (m + n) / 2 + 1);
            return (left + right) / 2.0;
        }
    }

  private:
    // this k starts from 1, not 0, notice here
    int findKthSortedArrays(vector<int> &nums1, vector<int> &nums2, int k) {
        int m = nums1.size();
        int n = nums2.size();
        int index1 = 0;
        int index2 = 0;

        while (true) {
            // edge situation
            // out of the bound
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            // k == 1
            if (k == 1) {
                return min(nums1[index1], nums2[index2]);
            }

            // normal situation
            int newIndex1 = min(index1 + k / 2 - 1, m - 1);
            int newIndex2 = min(index2 + k / 2 - 1, n - 1);
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else if (nums1[newIndex1] > nums2[newIndex2]) {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            } else {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
        }

        return -1;
    }
};

int main(int argc, char const *argv[]) {
    Solution solu;
    vector<int> nums1{1, 3};
    vector<int> nums2{2};
    double res = solu.findMedianSortedArrays(nums1, nums2);
    cout << res << endl;

    nums1 = vector<int>{1, 2};
    nums2 = vector<int>{3, 4};
    res = solu.findMedianSortedArrays(nums1, nums2);
    cout << res << endl;
    return 0;
}
