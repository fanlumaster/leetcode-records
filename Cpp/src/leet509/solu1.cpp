#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int fib(int n) {
    if (n <= 1)
      return n;
    vector<int> dp(n + 1, 0);
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++)
      dp[i] = dp[i - 1] + dp[i - 2];
    return dp[n];
  }
};

int main(int argc, char *argv[]) {
  Solution solu;
  int n = 4;
  int res = solu.fib(n);
  cout << res << "\n";
  return 0;
}