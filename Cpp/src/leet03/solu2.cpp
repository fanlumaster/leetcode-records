/**
 * 滑动窗口，让 right 去动，然后，left 控制 window 中没有重复的元素
 */
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <iostream>

using namespace std;

class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    if (s.length() == 0 || s.length() == 1)
      return s.length();
    unordered_set<char> char_set;
    for (int i = 0; i < s.length(); i++)
      char_set.insert(s[i]);
    if (char_set.size() == s.length())
      return s.length();
    unordered_map<char, int> window;
    for (char each : char_set)
      window[each] = 0;
    int left = 0;
    int right = 0;
    int res = 0;
    while (right < s.length()) {
      char cur_char = s[right];
      window[cur_char] += 1;
      while (window[cur_char] > 1) {
        if ((right - left) > res)
          res = right - left;
        window[s[left]] -= 1;
        left += 1;
      }
      right += 1;
    }
    if (right - left > res)
      res = right - left;
    return res;
  }
};

int main(int argc, char const *argv[]) {
  Solution solu;
  int res;
  res = solu.lengthOfLongestSubstring("abcabcbb");
  res = solu.lengthOfLongestSubstring("ru");
  cout << res << "\n";
  return 0;
}