package com.fan.leet715.solu1;

import java.util.Map;
import java.util.TreeMap;

class RangeModule {
  private TreeMap<Integer, Integer> intervals; // 有序键值对

  public RangeModule() {
    intervals = new TreeMap<>();
  }

  public void addRange(int left, int right) {
    Map.Entry<Integer, Integer> entry = intervals.higherEntry(left); // 返回严格大于 left 的那个键值对
    if (entry != intervals.firstEntry()) { // 如果可以找到严格大于 left 的键值对
      Map.Entry<Integer, Integer> start = entry != null ? intervals.lowerEntry(entry.getKey()) : intervals.lastEntry();
      if (start != null && start.getValue() >= right) {
        return;
      }
      if (start != null && start.getValue() >= left) {
        left = start.getKey();
        intervals.remove(start.getKey());
      }
    }

  }

  public boolean queryRange(int left, int right) {

    return false;
  }

  public void removeRange(int left, int right) {

  }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
