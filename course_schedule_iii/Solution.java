package course_schedule_iii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.add(course[0]);
            if (time>course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().scheduleCourse(new int[][] {{100,200},{200,1300},{1000,1250},{2000,3200}}));
    }
}
