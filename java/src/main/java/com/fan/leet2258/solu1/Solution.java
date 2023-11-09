package com.fan.leet2258.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * fany问题。此题不熟。
 */
public class Solution {
  private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 上、右、下、左

  /**
   * 火的 bfs
   *
   * grid: 格子
   * fire: 标记格子上的点是否着火
   * f: bfs 的起始需要遍历的值
   *
   * return bfs 一圈之后所有的着火点
   */
  private List<int[]> spreadFire(int[][] grid, boolean[][] fire, List<int[]> f) {
    int m = grid.length;
    int n = grid[0].length;
    List<int[]> tmp = f;
    f = new ArrayList<>();
    for (int[] p : tmp) {
      for (int[] d : DIRS) { // 枚举上右下左四个方向
        int x = p[0] + d[0];
        int y = p[1] + d[1];
        if (0 <= x && x < m && 0 <= y && y < n && !fire[x][y] && grid[x][y] == 0) {
          fire[x][y] = true; // 标记着火的位置
          f.add(new int[] { x, y });
        }
      }
    }
    return f;
  }

  /**
   * 返回能否在初始位置停留 t 分钟，并安全到达安全屋
   */
  private boolean check(int[][] grid, int t) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] onFire = new boolean[m][n];
    List<int[]> f = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          onFire[i][j] = true; // 标记着火的位置
          f.add(new int[] { i, j }); // dfs 的初始值
        }
      }
    }

    // 让火扩散 t 分钟，就是向外扩展 t 圈
    while (t-- > 0 && !f.isEmpty()) { // 如果火无法扩散就提前退出
      f = spreadFire(grid, onFire, f);
    }

    if (onFire[0][0]) { // 起点着火了
      return false;
    }

    // 人的 bfs
    boolean[][] vis = new boolean[m][n];
    vis[0][0] = true;
    List<int[]> nextCircle = List.of(new int[] { 0, 0 }); // 人从 (0, 0) 的位置开始尝试
    while (!nextCircle.isEmpty()) {
      List<int[]> curCircle = nextCircle;
      nextCircle = new ArrayList<>(); // 下一圈
      for (int[] p : curCircle) {
        if (onFire[p[0]][p[1]]) {
          // 如果这个位置已经着火了，因为人走过这一圈之后，火也会走一圈，
          // 这里不需要考虑安全屋，因为如果已经到安全屋的话，那么，就直接返回 true 了
          continue;

        }
        for (int[] d : DIRS) { // 四个方向
          int x = p[0] + d[0];
          int y = p[1] + d[1];
          // 如果在 grid 的边界内，并且这个位置没有着火，并且未访问过，并且这个格子是草地
          if (0 <= x && x < m && 0 <= y && y < n && !onFire[x][y] && !vis[x][y] && grid[x][y] == 0) {
            if (x == m - 1 && y == n - 1) { // 到达安全屋了
              return true;
            }
            vis[x][y] = true; // 防止重复访问
            nextCircle.add(new int[] { x, y });
          }
        }
      }
      f = spreadFire(grid, onFire, f); // 火也要同时扩散
    }
    return false;
  }

  public int maximumMinutes(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int left = -1;
    int right = m * n + 1; // 右边界可以取得大一点
    while (left + 1 < right) {
      int mid = (left + right) >>> 1; // 无符号右移一位
      if (check(grid, mid)) { // 符合条件就延长时间继续尝试
        left = mid;
      } else { // 否则缩减边界
        right = mid;
      }
    }
    return left < m * n ? left : 1_000_000_000;
  }

  public static void main(String[] args) {
    /*
     * 示例 1：
     * 输入：grid =
     * [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0
     * ,0]]
     * 输出：3
     * 解释：上图展示了你在初始位置停留 3 分钟后的情形。
     * 你仍然可以安全到达安全屋。
     * 停留超过 3 分钟会让你无法安全到达安全屋。
     * 
     * 示例 2：
     * 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
     * 输出：-1
     * 解释：上图展示了你马上开始朝安全屋移动的情形。
     * 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
     * 所以返回 -1 。
     * 
     * 示例 3：
     * 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
     * 输出：1000000000
     * 解释：上图展示了初始网格图。
     * 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
     * 所以返回 109 。
     */
    Solution solu = new Solution();
    int[][] grid = new int[][] { { 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 0, 2, 2, 1, 0 }, { 0, 2, 0, 0, 1, 2, 0 },
        { 0, 0, 2, 2, 2, 0, 2 }, { 0, 0, 0, 0, 0, 0, 0 } };
    int ans = solu.maximumMinutes(grid);
    System.out.println(ans);

    grid = new int[][] { { 0, 0, 0, 0 }, { 0, 1, 2, 0 }, { 0, 2, 0, 0 } };
    ans = solu.maximumMinutes(grid);
    System.out.println(ans);

    grid = new int[][] { { 0, 0, 0 }, { 2, 2, 0 }, { 1, 2, 0 } };
    ans = solu.maximumMinutes(grid);
    System.out.println(ans);
  }
}
