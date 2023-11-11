package com.full.unionfind.v2;

/**
 * 使用 size 来优化，在主要是在连通两棵树的时候有选择地去连接
 */
public class UnionFind {
  // 记录连通分量
  private int count;
  // 节点 x 的父节点是 parent[x]
  private int[] parent;
  // 记录树的重量
  private int[] size;

  // 构造函数，n 为图的节点总数
  public UnionFind(int n) {
    // 一开始互不连通
    this.count = n;
    // 指向父节点的指针一开始指向自己
    parent = new int[n];
    // 最初，每一棵树都只有一个节点，所以每一棵树的初始值都应该是 1
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
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
    // 将两棵树合并成一棵，并且，要使小树连在大树上面，这样会比较平衡
    if (size[rootP] > size[rootQ]) {
      parent[rootQ] = rootP;
      size[rootP] += size[rootQ];
    } else {
      parent[rootP] = rootQ;
      size[rootQ] += size[rootP];
    }
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
