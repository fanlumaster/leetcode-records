package com.fan.leet301.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private List<String> ans = new ArrayList<>();

  public List<String> removeInvalidParentheses(String s) {
    int lRemove = 0;
    int rRemove = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        lRemove += 1;
      } else if (s.charAt(i) == ')') {
        if (lRemove == 0) {
          rRemove += 1;
        } else {
          lRemove -= 1;
        }
      }
    }

    helper(s, 0, lRemove, rRemove);

    return ans;
  }

  private void helper(String str, int start, int lRemove, int rRemove) {
    if (lRemove == 0 && rRemove == 0) {
      if (isValid(str)) {
        ans.add(str);
      }
      return;
    }

    for (int i = start; i < str.length(); i++) {
      if (i != start && str.charAt(i) == str.charAt(i - 1)) {
        continue;
      }
      // 如果剩余的字符串无法满足去掉的数量的要求
      if (lRemove + rRemove > str.length() - i) {
        return;
      }
      // 去掉一个左括号
      if (lRemove > 0 && str.charAt(i) == '(') {
        helper(str.substring(0, i) + str.substring(i + 1), i, lRemove - 1,
            rRemove);
      }
      // 去掉一个右括号
      if (rRemove > 0 && str.charAt(i) == ')') {
        helper(str.substring(0, i) + str.substring(i + 1), i, lRemove,
            rRemove - 1);
      }
    }
  }

  private boolean isValid(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        cnt += 1;
      } else if (str.charAt(i) == ')') {
        cnt -= 1;
        if (cnt < 0) { // 如果在当前正在处理的位置这里，右括号的数量大于左括号的数量
          return false;
        }
      }
    }
    return cnt == 0;
  }

  public static void main(String[] args) {
    /*
     * 示例 1：
     * 输入：s = "()())()"
     * 输出：["(())()","()()()"]
     *
     * 示例 2：
     * 输入：s = "(a)())()"
     * 输出：["(a())()","(a)()()"]
     *
     * 示例 3：
     * 输入：s = ")("
     * 输出：[""]
     */

    Solution solu = new Solution();
    String s = "()())()";
    List<String> ans = solu.removeInvalidParentheses(s);
    System.out.println(Arrays.toString(ans.toArray()));

    s = "(a)())()";
    ans.clear();
    ans = solu.removeInvalidParentheses(s);
    System.out.println(Arrays.toString(ans.toArray()));

    s = ")(";
    ans.clear();
    ans = solu.removeInvalidParentheses(s);
    System.out.println(Arrays.toString(ans.toArray()));
  }
}
