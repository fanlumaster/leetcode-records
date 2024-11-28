/**
 * 直接暴力使用 set 进行处理
 */
#include <string>
#include <unordered_set>
#include <iostream>

using namespace std;

class Solution {
public:
  int lengthOfLongestSubstring(string s) {
    if (!s.length())
      return 0;
    unordered_set<char> char_set;
    int res = 1;
    for (int i = 0; i < s.length(); i++) {
      char_set.clear();
      char_set.insert(s[i]);
      for (int j = i + 1; j < s.length(); j++) {
        if (char_set.count(s[j]) > 0)
          break;
        char_set.insert(s[j]);
      }
      if (char_set.size() > res)
        res = char_set.size();
    }
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
