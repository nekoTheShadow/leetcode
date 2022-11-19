package erect_the_fence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public int[][] outerTrees(int[][] trees) {
        MonotoneChain mc = new MonotoneChain();
        for (int[] tree : trees) {
            mc.add(tree[0], tree[1]);
        }
        return mc.run();
    }
    
    
    public class MonotoneChain {
        private List<int[]> points;
        
        public MonotoneChain() {
            points = new ArrayList<>();
        }
        
        public void add(int x, int y) {
            points.add(new int[] {x, y});
        }
        
        public int[][] run() {
            if (points.size() <= 1) {
                return points.toArray(int[][]::new);
            }

            points.sort(Comparator.comparing((int[] p) -> p[0]).thenComparing(p -> p[1]));

            List<int[]> lower = new ArrayList<>();
            for (int[] p : points) {
                while (lower.size()>=2 && cross(lower.get(lower.size()-2), lower.get(lower.size()-1), p)<0) {
                    lower.remove(lower.size()-1);
                }
                lower.add(p);
            }
            
            List<int[]> upper = new ArrayList<>();
            Collections.reverse(points);
            for (int[] p : points) {
                while (upper.size()>=2 && cross(upper.get(upper.size()-2), upper.get(upper.size()-1), p)<0) {
                    upper.remove(upper.size()-1);
                }
                upper.add(p);
            }
            
            Set<int[]> ans = new HashSet<>();
            for (int i = 0, len = lower.size(); i < len-1; i++) {
                ans.add(lower.get(i));
            }
            for (int i = 0, len = upper.size(); i< len-1; i++) {
                ans.add(upper.get(i));
            }
            return ans.toArray(int[][]::new);
        }
        
        private int cross(int[] o, int[] a, int[] b) {
            return (a[0]-o[0])*(b[1]-o[1]) - (a[1]-o[1])*(b[0]-o[0]);
        }
    }

    
    public static void main(String[] args) {
        int[][] ans1 = new Main().outerTrees(new int[][] {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}});
        for (int[] row : ans1) System.out.println(Arrays.toString(row));
        
        System.out.println();
        
        int[][] ans2 = new Main().outerTrees(new int[][] {{1,2},{2,2},{4,2}});
        for (int[] row : ans2) System.out.println(Arrays.toString(row));
    }
}
