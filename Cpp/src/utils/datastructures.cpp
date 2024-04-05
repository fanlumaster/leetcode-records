#include "datastructures.h"
#include <iostream>
#include <queue>
#include <string>
#include <utility>

TreeNode *fany::buildTreeFromLevelOrder(std::vector<std::variant<int, std::string>> data) {
    int cnt = 0;
    std::queue<TreeNode *> q;
    TreeNode *root = new TreeNode(std::get<int>(data[0]));
    q.push(root);
    TreeNode *curNode = nullptr;

    for (int i = 1; i < data.size(); i++) {
        TreeNode *node = data[i].index() == 0 ? new TreeNode(std::get<int>(data[i])) : nullptr;
        if (cnt == 0) {
            curNode = q.front();
            q.pop();
            cnt++;
            curNode->left = node;
        } else {
            cnt = 0;
            curNode->right = node;
        }
        if (data[i].index() == 0) {
            q.push(node);
        }
    }

    return root;
}

std::pair<std::vector<std::string>, std::vector<int>> display_aux(TreeNode *node) {
    std::pair<std::vector<std::string>, std::vector<int>> res;
    auto string_multiply = [](const std::string &str, auto n) {
        std::string result;
        for (auto i = 0; i < n; ++i) {
            result += str;
        }
        return result;
    };
    if (!node->left && !node->right) {
        std::vector<std::string> curLines;
        std::string line = std::to_string(node->val);
        int width = int(line.size());
        int height = 1;
        int middle = width / 2;
        curLines.push_back(line);
        res.first = curLines;
        std::vector<int> fmtData{width, height, middle};
        res.second = fmtData;
        return res;
    } else if (!node->right) { // only left child
        std::vector<std::string> curLines;
        auto tmp = display_aux(node->left);
        auto lines = tmp.first;
        auto n = tmp.second[0];
        auto p = tmp.second[1];
        auto x = tmp.second[2];
        auto s = std::to_string(node->val);
        auto u = s.size();
        auto firstLine = string_multiply(" ", x + 1) + string_multiply("_", n - x - 1) + s;
        auto secondLine = string_multiply(" ", x) + "/" + string_multiply(" ", n - x - 1 + u);
        std::vector<std::string> shifted_lines;
        curLines.push_back(firstLine);
        curLines.push_back(secondLine);
        for (auto line : lines) {
            shifted_lines.push_back(line + string_multiply(" ", u));
            curLines.push_back(line + string_multiply(" ", u));
        }
        res.first = curLines;
        int width = int(n + u);
        int height = p + 2;
        int middle = int(n + u / 2);
        std::vector<int> fmtData{width, height, middle};
        res.second = fmtData;
        return res;
    } else if (!node->left) { // only right child
        std::vector<std::string> curLines;
        auto tmp = display_aux(node->right);
        auto lines = tmp.first;
        auto n = tmp.second[0];
        auto p = tmp.second[1];
        auto x = tmp.second[2];
        auto s = std::to_string(node->val);
        auto u = s.size();
        auto firstLine = s + string_multiply("_", x) + string_multiply(" ", n - x);
        auto secondLine = string_multiply(" ", u + x) + "\\" + string_multiply(" ", n - x - 1);
        std::vector<std::string> shifted_lines;
        curLines.push_back(firstLine);
        curLines.push_back(secondLine);
        for (auto line : lines) {
            shifted_lines.push_back(line + string_multiply(" ", u));
            curLines.push_back(line + string_multiply(" ", u));
        }
        res.first = curLines;
        int width = int(n + u);
        int height = p + 2;
        int middle = int(u / 2);
        std::vector<int> fmtData{width, height, middle};
        res.second = fmtData;
        return res;
    } else { // two children
        std::vector<std::string> curLines;
        auto leftInfo = display_aux(node->left);
        auto rightInfo = display_aux(node->right);
        auto leftLines = leftInfo.first;
        auto rightLines = rightInfo.first;
        auto n = leftInfo.second[0];
        auto p = leftInfo.second[1];
        auto x = leftInfo.second[2];
        auto m = rightInfo.second[0];
        auto q = rightInfo.second[1];
        auto y = rightInfo.second[2];
        auto s = std::to_string(node->val);
        auto u = s.size();
        auto firstLine = string_multiply(" ", x + 1) + string_multiply("_", n - x - 1) + s + string_multiply("_", y) + string_multiply(" ", m - y);
        auto secondLine = string_multiply(" ", x) + "/" + string_multiply(" ", n - x - 1 + u + y) + "\\" + string_multiply(" ", m - y - 1);
        if (p < q) {
            for (int i = 0; i < q - p; i++) {
                leftLines.push_back(string_multiply(" ", n));
            }
        } else if (p > q) {
            for (int i = 0; i < p - q; i++) {
                rightLines.push_back(string_multiply(" ", n));
            }
        }
        curLines.push_back(firstLine);
        curLines.push_back(secondLine);
        for (int i = 0; i < leftLines.size(); i++) {
            curLines.push_back(leftLines[i] + string_multiply(" ", u) + rightLines[i]);
        }
        res.first = curLines;
        int width = int(n + m + u);
        int height = std::max(p, q) + 2;
        int middle = int(n + u / 2);
        std::vector<int> fmtData{width, height, middle};
        res.second = fmtData;
        return res;
    }
}

void fany::displayTree(TreeNode *node) {
    auto lines = display_aux(node).first;
    for (auto line : lines) {
        std::cout << line << "\n";
    }
}

void fany::makeEmpty(TreeNode *&t) {
    if (t != nullptr) {
        makeEmpty(t->left);
        makeEmpty(t->right);
        delete t;
    }
    t = nullptr;
}

/*
int main(int argc, char *argv[]) {
    std::vector<std::variant<int, std::string>> data = {4, -7, -3, "null", "null", -9, -3, 9, -7, -4, "null", 6, "null", -6, -6, "null", "null", 0, 6, 5, "null", 9, "null", "null", -1, -4, "null", "null", "null", -2};
    TreeNode *root = fany::buildTreeFromLevelOrder(data);
    fany::displayTree(root);
    fany::makeEmpty(root);
    return 0;
}
*/

/*
Expected output:
  4_____________________
 /                      \
-7           __________-3___
            /               \
           -9____          -3
          /      \        /
       ___9     -7____   -4
      /        /      \
    __6__     -6     -6
   /     \   /      /
   0_    6   5      9
     \  /          /
   -1  -4         -2
*/
