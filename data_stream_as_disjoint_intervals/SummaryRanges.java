package data_stream_as_disjoint_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SummaryRanges {
    private MergeInterval mi;
    
    public SummaryRanges() {
        this.mi = new MergeInterval();
    }
    
    public void addNum(int value) {
        mi.add(value, value);
    }
    
    public int[][] getIntervals() {
        List<int[]> intervals = mi.merge();
        return intervals.toArray(int[][]::new);
    }
    

    public class MergeInterval {
        private List<int[]> intervals;
        
        public MergeInterval() {
            this.intervals = new ArrayList<>();
        }
        
        public void add(int begin, int end) {
            intervals.add(new int[] {begin, end});
        }
        
        public List<int[]> merge() {
            List<int[]> stack = new ArrayList<>();
            int n = -1;
            Collections.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparing(a -> a[1]));
            for (int[] cur : intervals) {
                if (n == -1 || stack.get(n)[1]+1 < cur[0]) {
                    stack.add(cur);
                    n++;
                } else {
                    stack.get(n)[1] = Math.max(stack.get(n)[1], cur[1]);
                }
            }
            
            intervals = stack;
            return intervals;
        }
    }
    
    
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        summaryRanges.getIntervals(); // return [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
    }
}
