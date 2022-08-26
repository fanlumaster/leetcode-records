using CSharp.src.utils;

namespace CSharp.src.leet108
{
    public class Solution
    {
        public TreeNode SortedArrayToBST(int[] nums)
        {
            List<int> numsList = new List<int>(nums);
            TreeNode res = recurse(numsList);

            return res;
        }

        private TreeNode recurse(List<int> numsList)
        {
            if (numsList.Count == 0)
            {
                return null;
            }
            int mid = numsList.Count / 2;
            TreeNode curNode = new TreeNode(numsList[mid]);
            List<int> leftSubList = numsList.GetRange(0, mid);
            List<int> rightSubList = (mid >= numsList.Count - 1) ? new List<int>() : numsList.GetRange(mid + 1, numsList.Count - mid - 1);
            curNode.left = recurse(leftSubList);
            curNode.right = recurse(rightSubList);
            return curNode;
        }
    }
}
