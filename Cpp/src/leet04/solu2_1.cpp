#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
  double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
    int m = nums1.size();
    int n = nums2.size();
    if ((m + n) % 2)
      return findKthSortedArrays(nums1, nums2, ((m + n + 1) >> 1), false);
    else
      return findKthSortedArrays(nums1, nums2, (m + n) >> 1, true);
  }

  /**
   * k starts from 1, not 0
   */
  double findKthSortedArrays(vector<int> &nums1, vector<int> &nums2, int k, bool needAnother) {
    int m = nums1.size();
    int n = nums2.size();
    if (m > n)
      return findKthSortedArrays(nums2, nums1, k, needAnother);
    int idx1 = 0;
    int idx2 = 0;
    int newIdx1 = 0;
    int newIdx2 = 0;
    double res;
    if (m == 0) {
      res = nums2[k - 1];
      idx2 = k;
      if (needAnother) {
        return (res + nums2[k]) / 2.0;
      }
      return res;
    }
    while (true) {
      if (k == 1) {
        if (nums1[idx1] < nums2[idx2]) {
          res = nums1[idx1];
          idx1 += 1;
        } else {
          res = nums2[idx2];
          idx2 += 1;
        }
        break;
      }
      // 1. 要取的是当前半个部分的末尾元素
      newIdx1 = min(idx1 + (k >> 1) - 1, m - 1);
      newIdx2 = min(idx2 + (k >> 1) - 1, n - 1);
      if (nums1[newIdx1] < nums2[newIdx2]) {
        k -= (newIdx1 - idx1 + 1);
        // 2. 因为是小的那半部分(而且这个是向下取整)，所以可以全部跳过
        idx1 = newIdx1 + 1;
        if (newIdx1 == m - 1) {
          idx1 = m;
          idx2 = idx2 + k - 1;
          res = nums2[idx2];
          idx2 += 1;
          break;
        }
      } else {
        k -= (newIdx2 - idx2 + 1);
        idx2 = newIdx2 + 1;
        if (newIdx2 == n - 1) {
          idx2 = n;
          idx1 = idx1 + k - 1;
          res = nums1[idx1];
          idx1 += 1;
          break;
        }
      }
    }
    if (needAnother) {
      double another;
      if (idx1 == m)
        another = nums2[idx2];
      else if (idx2 == n)
        another = nums1[idx1];
      else
        another = nums1[idx1] < nums2[idx2] ? nums1[idx1] : nums2[idx2];
      res = (res + another) / 2.0;
    }
    return res;
  }
};

int main(int argc, char *argv[]) {
  Solution solu;
  vector<int> nums1 = {1, 3};
  vector<int> nums2 = {2};
  nums1 = {1, 2};
  nums2 = {3, 4};
  nums1 = {};
  nums2 = {1};
  // nums1 = {};
  // nums2 = {2, 3};
  double res = solu.findMedianSortedArrays(nums1, nums2);
  cout << res << "\n";
  return 0;
}
