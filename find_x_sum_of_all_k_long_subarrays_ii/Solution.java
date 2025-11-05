package find_x_sum_of_all_k_long_subarrays_ii;

import java.util.*;

public class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        MySet mySet = new MySet(x);
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            mySet.insert(nums[i]);
            if (i - k >= 0) {
                mySet.remove(nums[i - k]);
            }
            if (i - k + 1 >= 0) {
                ans.add(mySet.getTotal());
            }
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }
}

class MySet {
    private final int x;
    private final TreeSet<Tuple> large;
    private final TreeSet<Tuple> small;
    private final Map<Long, Integer> freq;
    private long total;

    public MySet(int x) {
        this.x = x;
        this.freq = new HashMap<>();
        this.large = new TreeSet<>();
        this.small = new TreeSet<>();
        this.total = 0;
    }

    public void insert(long value) {
        int count = freq.getOrDefault(value, 0);
        if (count > 0) {
            internalRemove(new Tuple(count, value));
        }

        int newCount = count + 1;
        freq.put(value, newCount);
        internalInsert(new Tuple(newCount, value));
    }

    public void remove(long value) {
        int count = freq.get(value);
        internalRemove(new Tuple(count, value));

        int newCount = count - 1;
        freq.put(value, newCount);
        if (newCount > 0) {
            internalInsert(new Tuple(newCount, value));
        }
    }

    public long getTotal() {
        return total;
    }

    private void internalInsert(Tuple p) {
        if (large.size() < x || large.first().compareTo(p) < 0) {
            large.add(p);
            total += p.count() * p.value();
            if (x < large.size()) {
                Tuple q = large.removeFirst();
                total -= q.count() * q.value();
                small.add(q);
            }
        } else {
            small.add(p);
        }
    }

    private void internalRemove(Tuple p) {
        if (large.contains(p)) {
            large.remove(p);
            total -= p.count() * p.value();
            if (!small.isEmpty()) {
                Tuple q = small.removeLast();
                total += q.count() * q.value();
                large.add(q);
            }
        } else {
            small.remove(p);
        }
    }
}

record Tuple(int count, long value) implements Comparable<Tuple> {
    @Override
    public int compareTo(Tuple other) {
        int c = Integer.compare(this.count, other.count);
        return c == 0 ? Long.compare(this.value, other.value) : c;
    }
}
