#include "datastructures.h"
#include <iostream>

class Solution {
  public:
    int maxDepth(TreeNode *root) {
        if (!root) {
            return 0;
        }
        maxDepthHelp(root, 1);

        return this->res;
    }

  private:
    int res = 0;
    void maxDepthHelp(TreeNode *root, int curDepth) {
        if (!root->left && !root->right) {
            if (curDepth > res) {
                this->res = curDepth;
            }
            return;
        }
        if (root->left) {
            maxDepthHelp(root->left, curDepth + 1);
        }
        if (root->right) {
            maxDepthHelp(root->right, curDepth + 1);
        }
    }
};

int main(int argc, char *argv[]) {
    Solution solu;
    // case1
    std::vector<std::variant<int, std::string>> data = {3, 9, 20, "null", "null", 15, 7};
    // case2
    data = {1, "null", 2};
    TreeNode *root = fany::buildTreeFromLevelOrder(data);
    /* fany::displayTree(root); */
    auto res = solu.maxDepth(root);
    std::cout << "res: " << res << "\n";

    // 回收内存
    fany::makeEmpty(root);
    return 0;
}
