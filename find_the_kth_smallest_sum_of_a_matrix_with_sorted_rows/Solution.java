package find_the_kth_smallest_sum_of_a_matrix_with_sorted_rows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        pq.add(Entry.first(mat));

        for (int i = 0; i < k-1; i++) {
            Entry e = pq.poll();
            pq.addAll(e.nexts());
        }

        return pq.poll().score();
    }

    private static class Entry implements Comparable<Entry>{
        private static int[][] mat;
        private static Set<Entry> visited;
        private int[] idxs;

        private Entry(int[] idxs) {
            this.idxs = idxs;
        }

        public static Entry first(int[][] mat) {
            Entry.mat = mat;
            Entry.visited = new HashSet<>();

            Entry e = new Entry(new int[mat.length]);
            visited.add(e);
            return e;
        }

        public List<Entry> nexts() {
            List<Entry> entries = new ArrayList<>();

            for (int i = 0; i < mat.length; i++) {
                if (idxs[i] == mat[0].length - 1) continue;

                int[] nextIdxs = idxs.clone();
                nextIdxs[i]++;
                Entry entry = new Entry(nextIdxs);
                if (!visited.contains(entry)) {
                    entries.add(entry);
                    visited.add(entry);
                }
            }

            return entries;
        }

        @Override
        public int compareTo(Entry other) {
            return Integer.compare(this.score(), other.score());
        }

        public int score() {
            return IntStream.range(0, mat.length).map(i -> mat[i][idxs[i]]).sum();
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(idxs);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry other = (Entry) obj;
            return Arrays.equals(idxs, other.idxs);
        }
    }
}
