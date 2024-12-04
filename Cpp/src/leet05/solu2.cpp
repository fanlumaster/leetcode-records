#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  string longestPalindrome(string s) {
    if (s.length() <= 1)
      return s;
    string maxStr = s.substr(0, 1);
    vector<vector<bool>> dp(s.length(), vector<bool>(s.length(), false));
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
      for (int j = 0; j < i; j++)
        if (s[j] == s[i] && (i - j <= 2 || dp[j + 1][i - 1])) {
          dp[j][i] = true;
          if (i - j + 1 > maxStr.length())
            maxStr = s.substr(j, i - j + 1);
        }
    }
    return maxStr;
  }
};

int main(int argc, char *argv[]) {
  Solution solu;
  string s = "babad";
  string res = solu.longestPalindrome(s);
  s = "bb";
  s = "aaaa";
  res = solu.longestPalindrome(s);
  cout << res << "\n";
  return 0;
}
