#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
  string longestPalindrome(string s) {
    if (s.length() <= 1)
      return s;
    string maxStr = s.substr(0, 1);
    for (int i = 0; i < s.length() - 1; i++) {
      string odd = expandFromCenter(s, i, i);
      string even = expandFromCenter(s, i, i + 1);
      if (odd.length() > maxStr.length())
        maxStr = odd;
      if (even.length() > maxStr.length())
        maxStr = even;
    }
    return maxStr;
  }

private:
  string expandFromCenter(string s, int left, int right) {
    while (left >= 0 && right <= s.length() - 1 && s[left] == s[right]) {
      left -= 1;
      right += 1;
    }
    return s.substr(left + 1, right - left - 1);
  }
};

int main(int argc, char *argv[]) {
  Solution solu;
  string s = "babad";
  string res = solu.longestPalindrome(s);
  cout << res << "\n";

  return 0;
}
