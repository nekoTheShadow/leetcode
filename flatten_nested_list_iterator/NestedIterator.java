package flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class NestedIterator implements Iterator<Integer> {
    
    private int cur;
    private List<Integer> integers;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.cur = 0;
        this.integers = nestedList.stream().flatMap(nestedInteger -> flattern(nestedInteger).stream()).collect(Collectors.toList());
    }
    
    private List<Integer> flattern(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            return List.of(nestedInteger.getInteger());
        }
        return nestedInteger.getList().stream().flatMap(v -> flattern(v).stream()).collect(Collectors.toList());
    }

    @Override
    public Integer next() {
        return integers.get(cur++);
    }

    @Override
    public boolean hasNext() {
        return cur < integers.size();
    }
    
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}