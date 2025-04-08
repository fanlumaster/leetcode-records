#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  string convert(string s, int numRows) {
    if (numRows == 1 || s.length() <= numRows)
      return s;
    int direct = 1; // Moving from top to down
    vector<string> resVec(numRows);
    int curRow = 0;
    int i = 0;
    while (i < s.length()) {
      int curLoopTimes = s.length() - i >= (numRows - 1) //
                             ? (numRows - 1)             //
                             : s.length() - i;           //
      if (s.length() - i == 1) {
        curLoopTimes = 1;
      }
      for (int j = 0; j < curLoopTimes; j++) {
        resVec[curRow] += s[i + j];
        curRow += direct;
      }
      direct = -direct;
      i += curLoopTimes;
    }
    string res;
    for (auto each : resVec)
      res += each;
    return res;
  }
};

int main(int argc, char *argv[]) {
  Solution s;
  string s1 = "PAYPALISHIRING";
  string res = s.convert(s1, 3);
  cout << res << "\n";
  cout << (res == "PAHNAPLSIIGYIR" ? "true" : "false") << "\n";
  s1 = "A";
  res = s.convert(s1, 1);
  cout << res << "\n";
  s1 = "ABC";
  res = s.convert(s1, 2);
  cout << res << "\n";
  return 0;
}