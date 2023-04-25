package smallest_number_in_infinite_set;

import java.util.TreeSet;

public class SmallestInfiniteSet {
    private TreeSet<Integer> ts;
    
    public SmallestInfiniteSet() {
        ts = new TreeSet<>();
        for (int i = 1; i <= 1001; i++) {
            ts.add(i);
        }
    }
    
    public int popSmallest() {
        return ts.pollFirst();
    }
    
    public void addBack(int num) {
        ts.add(num);
    }
}
