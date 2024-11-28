#include <string>
#include <vector>
#include <variant>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

namespace fany {
// 从二叉树的层序遍历构造一棵二叉树
TreeNode *buildTreeFromLevelOrder(std::vector<std::variant<int, std::string>> data);

// 形象化打印一棵二叉树
void displayTree(TreeNode *node);

// 回收内存
void makeEmpty(TreeNode *&t);
} // namespace fany