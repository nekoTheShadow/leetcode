package flatten_nested_list_iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator2 implements Iterator<Integer> {
    
    private Deque<NestedInteger> stack;
    
    public NestedIterator2(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        append(nestedList);
    }

    @Override
    public Integer next() {
        return stack.removeLast().getInteger();
    }
    
    public void append(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1; i >= 0; i--) {
            stack.addLast(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.getLast().isInteger()) {
            append(stack.removeLast().getList());
        }
        return !stack.isEmpty();
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