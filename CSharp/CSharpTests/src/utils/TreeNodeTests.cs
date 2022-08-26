using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace CSharp.src.utils.Tests
{
    [TestClass()]
    public class TreeNodeTests
    {
        [TestMethod()]
        public void TreeNodeTest()
        {
            TreeNode root1 = new TreeNode();
            TreeNode root2 = new TreeNode(1);

            Console.WriteLine(root1.val);
            Console.WriteLine(root2.val);
        }
    }
}