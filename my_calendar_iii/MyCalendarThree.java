package my_calendar_iii;

import java.util.TreeMap;

public class MyCalendarThree {

    private TreeMap<Integer, Integer> tree;

    public MyCalendarThree() {
        tree = new TreeMap<>();
    }

    public int book(int start, int end) {
        tree.put(start, tree.getOrDefault(start, 0) + 1);
        tree.put(end, tree.getOrDefault(end, 0) - 1);

        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int v : tree.values()) {
            sum += v;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

