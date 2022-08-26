namespace CSharp.src.utils
{
    public class BinaryTreeUtils
    {
        public static TreeNode BuildBinTreeFromLevelOrder(List<int?> data)
        {
            int count = 0;
            Queue<TreeNode> q = new Queue<TreeNode>();
            TreeNode root = new TreeNode(data[0]);
            q.Enqueue(root);
            TreeNode curNode = null;

            for (int i = 1; i < data.Count; i++)
            {
                TreeNode? tmpNode;
                if (data[i] != null)
                {
                    tmpNode = new TreeNode(data[i]);
                }
                else
                {
                    tmpNode = null;
                }


                if (count == 0)
                {
                    curNode = q.Dequeue();
                    count++;
                    curNode.left = tmpNode;
                }
                else
                {
                    count = 0;
                    curNode.right = tmpNode;
                }

                if (data[i] != null)
                {
                    q.Enqueue(tmpNode);
                }
            }

            return root;
        }

        public static void PrintBinTree(TreeNode root)
        {
            List<List<string>> lines = new List<List<string>>();

            List<TreeNode> level = new List<TreeNode>();
            List<TreeNode> next = new List<TreeNode>();

            level.Add(root);
            int nn = 1;

            int widest = 0;

            while (nn != 0)
            {
                List<string> line = new List<string>();

                nn = 0;

                foreach (TreeNode n in level)
                {
                    if (n == null)
                    {
                        line.Add(null);

                        next.Add(null);
                        next.Add(null);
                    }
                    else
                    {
                        string aa = n.val.ToString();
                        line.Add(aa);
                        if (aa.Length > widest)
                        {
                            widest = aa.Length;
                        }
                        next.Add(n.left);
                        next.Add(n.right);

                        if (n.left != null)
                        {
                            nn++;
                        }
                        if (n.right != null)
                        {
                            nn++;
                        }
                    }
                }

                if (widest % 2 == 1)
                {
                    widest++;
                }

                lines.Add(line);

                List<TreeNode> tmp = level;
                level = next;
                next = tmp;
                next.Clear();
            }

            int perpiece = lines[lines.Count - 1].Count * (widest + 4);
            for (int i = 0; i < lines.Count; i++)
            {
                List<string> line = lines[i];
                int hpw = (int)Math.Floor(perpiece / 2f) - 1;

                if (i > 0)
                {
                    for (int j = 0; j < line.Count; j++)
                    {
                        // split code
                        char c = ' ';
                        if (j % 2 == 1)
                        {
                            if (line[j - 1] != null)
                            {
                                c = (line[j] != null) ? '┴' : '┘';
                            }
                            else
                            {
                                if (j < line.Count && line[j] != null)
                                {
                                    c = '└';
                                }
                            }
                        }
                        Console.Write(c);

                        // lines and spaces
                        if (line[j] == null)
                        {
                            for (int k = 0; k < perpiece - 1; k++)
                            {
                                Console.Write(" ");
                            }
                        }
                        else
                        {
                            for (int k = 0; k < hpw; k++)
                            {
                                Console.Write(j % 2 == 0 ? " " : "─");
                            }
                            Console.Write(j % 2 == 0 ? "┌" : "┐");
                            for (int k = 0; k < hpw; k++)
                            {
                                Console.Write(j % 2 == 0 ? "─" : " ");
                            }
                        }
                    }
                    Console.WriteLine();
                }

                // print line of number
                for (int j = 0; j < line.Count; j++)
                {
                    string f = line[j];
                    if (f == null)
                    {
                        f = "";
                    }
                    int gap1 = (int)Math.Ceiling(perpiece / 2f - f.Length / 2f);
                    int gap2 = (int)Math.Floor(perpiece / 2f - f.Length / 2f);

                    // a number
                    for (int k = 0; k < gap1; k++)
                    {
                        Console.Write(" ");
                    }
                    Console.Write(f);
                    for (int k = 0; k < gap2; k++)
                    {
                        Console.Write(" ");
                    }
                }
                Console.WriteLine();

                perpiece /= 2;
            }
        }
    }
}
