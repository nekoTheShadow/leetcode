package linked_list_random_node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    private ListNode head;
    private Random random;
    
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    public int getRandom() {
        List<ListNode> a = reservoirSample(random, new ListNodeIterator(head), 1);
        return a.get(0).val;
    }
    
    public class ListNodeIterator implements Iterator<ListNode> {
        private ListNode head;
        
        public ListNodeIterator(ListNode head) {
            this.head = head;
        }

        @Override
        public boolean hasNext() {
            return this.head != null;
        }

        @Override
        public ListNode next() {
            ListNode cur = head;
            head = head.next;
            return cur;
        }
    }
    
    public <E> List<E> reservoirSample(Random random, Iterator<E> iterator, int k) {
        int n = 0;
        List<E> list = new ArrayList<>();
        while (iterator.hasNext()) {
            E e = iterator.next();
            if (n < k) {
                list.add(e);
            } else {
                int i = random.nextInt(n+1);
                if (i < k) {
                    list.set(i, e);
                }
            }
            n++;
        }
        return list;
    }
    
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static void main(String[] args) {
        List<ListNode> nodes = IntStream.of(10,1,10,20,100).mapToObj(val -> new ListNode(val, null)).collect(Collectors.toList());
        for (int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i).next = nodes.get(i+1);
        }
        
        Solution solution = new Solution(nodes.get(0));
        System.out.println(solution.getRandom());
//        System.out.println(solution.getRandom());
    }
}
