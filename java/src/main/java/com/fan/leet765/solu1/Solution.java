package com.fan.leet765.solu1;

public class Solution {
  /**
   * 这里是使用路径压缩来处理(递归)，这里 size 其实就没有什么必要了，直接去掉
   */
  private class UnionFind {
    // 记录连通分量
    private int count;
    // 节点 x 的父节点是 parent[x]
    private int[] parent;

    // 构造函数，n 为图的节点总数
    public UnionFind(int n) {
      // 一开始互不连通
      this.count = n;
      // 指向父节点的指针一开始指向自己
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    // 返回某个节点 x 的根节点
    // 路径压缩，压缩得很彻底，最终除了根节点，所有节点都是指向那唯一一个根节点
    private int find(int x) {
      if (parent[x] != x) {
        parent[x] = find(parent[x]);
      }
      return parent[x];
    }

    // 把 p 和 q 连通起来
    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);

      if (rootP == rootQ) {
        return;
      }
      // 将两棵树合并成一棵，并且，要使小树连在大树上面，这样会比较平衡
      parent[rootQ] = rootP;

      count--; // 两个分量合二为一
    }

    // 返回当前的连通分量个数
    public int count() {
      return count;
    }

    public boolean connected(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      return rootP == rootQ;
    }
  }

  public int minSwapsCouples(int[] row) {
    int len = row.length;
    int N = len / 2;
    UnionFind unionFind = new UnionFind(N);
    for (int i = 0; i < len; i += 2) {
      unionFind.union(row[i] / 2, row[i + 1] / 2);
    }
    return N - unionFind.count();
  }

  public static void main(String[] args) {
    /*
     * 示例 1:
     * 输入: row = [0,2,1,3]
     * 输出: 1
     * 解释: 只需要交换row[1]和row[2]的位置即可。
     *
     * 示例 2:
     * 输入: row = [3,2,0,1]
     * 输出: 0
     * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
     */
    var solu = new Solution();
    int[] row = new int[] { 0, 2, 1, 3 };
    int ans = solu.minSwapsCouples(row);
    System.out.println(ans);

    row = new int[] { 3, 2, 0, 1 };
    ans = solu.minSwapsCouples(row);
    System.out.println(ans);
  }
}
