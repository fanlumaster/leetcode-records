using CSharp.src.utils;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace CSharp.src.leet108.Tests
{
    [TestClass()]
    public class SolutionTests
    {
        [TestMethod()]
        public void SortedArrayToBSTTest()
        {
            var solu = new Solution();
            var data = new List<int?> { 0, -3, 9, -10, null, 5 };
            var root = BinaryTreeUtils.BuildBinTreeFromLevelOrder(data);
            BinaryTreeUtils.PrintBinTree(root);
            Console.WriteLine("============================");
            var nums = new int[] { -10, -3, 0, 5, 9 };
            var res = solu.SortedArrayToBST(nums);
            BinaryTreeUtils.PrintBinTree(res);
        }

        [TestMethod()]
        public void TestList()
        {
            var list = new List<int>();
            Console.WriteLine(list.Count);
        }
    }
}