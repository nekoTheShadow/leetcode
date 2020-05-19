package maximu_frequency_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqStack {
    private List<Deque<Integer>> values;
    private Map<Integer, Integer> counts;  // KEY=値 VALUE=回数

    public FreqStack() {
        values = new ArrayList<>();
        counts = new HashMap<>();
    }

    public void push(int x) {
        int count = counts.getOrDefault(x, 0);
        while (values.size() <= count) {
            values.add(new ArrayDeque<>());
        }
        values.get(count).add(x);
        counts.put(x, count+1);
    }


    public int pop() {
        int last = values.size()-1;
        int x = values.get(last).removeLast();
        if (values.get(last).isEmpty()) {
            values.remove(last);
        }
        counts.put(x, counts.get(x)-1);
        return x;
    }

}
