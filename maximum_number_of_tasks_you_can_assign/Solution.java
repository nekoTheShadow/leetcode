package maximum_number_of_tasks_you_can_assign;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
  public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
    Arrays.sort(tasks);

    int ok = 0;
    int ng = tasks.length + 1;
    while (Math.abs(ok - ng) > 1) {
      int mi = (ok + ng) / 2;
      if (check(mi, tasks, workers, pills, strength)) {
        ok = mi;
      } else {
        ng = mi;
      }
    }
    return ok;
  }

  private boolean check(int k, int[] tasks, int[] workers, int pills, int strength) {
    TreeMap<Integer, Long> h = Arrays.stream(workers).boxed()
        .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));


    // 簡単なK個のうち、難しいタスクから処理をはじめる
    for (int i = k - 1; i >= 0; i--) {
      int task = tasks[i];

      // 1. 対象のタスクをピルなしで完了できる作業者がいるかどうかを確認する。
      Integer worker1 = h.ceilingKey(task);
      if (worker1 != null) {
        decrement(h, worker1);
        continue;
      }

      // 2. 対象のタスクをピルありで完了できる労働者がいるかどうかを確認する。
      if (pills == 0) {
        return false;
      }

      Integer worker2 = h.ceilingKey(task - strength);
      if (worker2 == null) {
        return false;
      }
      decrement(h, worker2);
      pills--;
    }

    return true;
  }

  private void decrement(TreeMap<Integer, Long> h, int key) {
    Long value = h.get(key);
    if (value == 1) {
      h.remove(key);
    } else {
      h.put(key, value - 1);
    }
  }
}
