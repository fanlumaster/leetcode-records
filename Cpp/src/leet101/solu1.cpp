#include "datastructures.h"
#include <iostream>
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */

class Solution {
  public:
    bool check(TreeNode *p, TreeNode *q) {
        if (!p && !q)
            return true;
        if (!p || !q)
            return false;
        return (p->val == q->val) && check(p->left, q->right) && check(p->right, q->left);
    }

    bool isSymmetric(TreeNode *root) { return check(root->left, root->right); }
};

int main(int argc, char *argv[]) {
    Solution solu;
    // case1
    std::vector<std::variant<int, std::string>> data = {1, 2, 2, 3, 4, 4, 3};
    // case2
    data = {1, 2, 2, "null", 3, "null", 3};
    TreeNode *root = fany::buildTreeFromLevelOrder(data);
    auto res = solu.isSymmetric(root);
    std::cout << "res: " << res << "\n";
    return 0;
}
