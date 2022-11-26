package maximum_profit_in_job_scheduling;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().jobScheduling(new int[] {1,2,3,3}, new int[] {3, 4, 5, 6}, new int[] {50,10,40,70}));
        System.out.println(new Main().jobScheduling(new int[] {1,2,3,4,6}, new int[] {3,5,10,6,9}, new int[] {20,20,100,70,60}));
        System.out.println(new Main().jobScheduling(new int[] {1,1,1}, new int[] {2,3,4}, new int[] {5,6,4}));
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = IntStream.range(0, startTime.length).mapToObj(i -> new int[] {startTime[i], endTime[i], profit[i]}).sorted(Comparator.comparing(a -> a[1])).toArray(int[][]::new);
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0);
        for (int[] job : jobs) {
            dp.put(job[1], Math.max(dp.lastEntry().getValue(), dp.floorEntry(job[0]).getValue() + job[2]));
        }
        return dp.lastEntry().getValue();
    }
    
}
