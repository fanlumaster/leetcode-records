package com.full.unionfind.v1;

/**
 * 最基础版本的并查集
 */
public class UnionFind {
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
  private int find(int x) {
    while (parent[x] != x) {
      x = parent[x];
    }
    return x;
  }

  // 把 p 和 q 连通起来
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }
    // 将两棵树合并成一棵
    parent[rootP] = rootQ;
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
