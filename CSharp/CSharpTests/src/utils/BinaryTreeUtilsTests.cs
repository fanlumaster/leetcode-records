using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace CSharp.src.utils.Tests
{
    [TestClass()]
    public class BinaryTreeUtilsTests
    {
        [TestMethod()]
        public void PrintBinTreeTest()
        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(6);

            BinaryTreeUtils.PrintBinTree(root);
        }

        [TestMethod()]
        public void BuildBinTreeFromLevelOrderTest()
        {
            var data = new List<int?> { 1, 2, 3, 4, 5, 6, 7, null, 8, 9, 10, 11, 12, 13, 14 };
            var root = BinaryTreeUtils.BuildBinTreeFromLevelOrder(data);
            BinaryTreeUtils.PrintBinTree(root);
        }
    }
}