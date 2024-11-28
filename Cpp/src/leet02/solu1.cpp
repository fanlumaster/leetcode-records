/**
 * 直接一个一个处理，不然，如果先转换成字符串再转整数的话，int 和 long 的长度都不够。
 */
#include <string>
#include <iostream>

struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
  ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    char overflow = 0;
    ListNode *res = new ListNode(-1);
    ListNode *res_temp = res;
    while (l1 && l2) {
      char cur_digit = l1->val + l2->val + overflow;
      overflow = cur_digit > 9 ? 1 : 0;
      res_temp->next = new ListNode(cur_digit % 10);
      l1 = l1->next;
      l2 = l2->next;
      res_temp = res_temp->next;
    }
    while (l1) {
      char cur_digit = l1->val + overflow;
      overflow = cur_digit > 9 ? 1 : 0;
      res_temp->next = new ListNode(cur_digit % 10);
      l1 = l1->next;
      res_temp = res_temp->next;
    }
    while (l2) {
      char cur_digit = l2->val + overflow;
      overflow = cur_digit > 9 ? 1 : 0;
      res_temp->next = new ListNode(cur_digit % 10);
      l2 = l2->next;
      res_temp = res_temp->next;
    }
    if (overflow)
      res_temp->next = new ListNode(overflow);
    return res->next;
  }
};

int main(int argc, char const *argv[]) {
  Solution solu;
  ListNode *l1 = new ListNode(2);
  l1->next = new ListNode(4);
  l1->next->next = new ListNode(3);
  ListNode *l2 = new ListNode(5);
  l2->next = new ListNode(6);
  l2->next->next = new ListNode(4);
  ListNode *res = solu.addTwoNumbers(l1, l2);
  while (res) {
    std::cout << res->val;
    res = res->next;
  }
  std::cout << "\n";
}
