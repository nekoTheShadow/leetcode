package kth_smallest_product_of_two_sorted_arrays;

import java.util.Arrays;
import java.util.stream.LongStream;

public class Solution {
  public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
    long[] a1 = Arrays.stream(nums1).mapToLong(Long::valueOf).toArray();
    long[] a2 = Arrays.stream(nums2).mapToLong(Long::valueOf).toArray();

    long p1 = a1[0];
    long q1 = a1[a1.length - 1];
    long p2 = a2[0];
    long q2 = a2[a2.length - 1];

    long ng = LongStream.of(p1 * p2, p1 * q2, q1 * p2, q1 * q2).min().getAsLong() - 1;
    long ok = LongStream.of(p1 * p2, p1 * q2, q1 * p2, q1 * q2).max().getAsLong() + 1;
    while (Math.abs(ok - ng) > 1) {
      long mi = (ok + ng) / 2;
      if (count(a1, a2, mi) >= k) {
        ok = mi;
      } else {
        ng = mi;
      }
    }
    return ok;
  }

  private long count(long[] a1, long[] a2, long x) {
    long count = 0;
    for (long v2 : a2) {
      if (v2 > 0) {
        count += bisectRight(a1, Math.floorDiv(x, v2));
      } else if (v2 < 0) {
        count += a1.length - bisectLeft(a1, Math.ceilDiv(x, v2));
      } else {
        if (x >= 0) {
          count += a1.length;
        }
      }
    }

    return count;
  }

  private long bisectRight(long[] a, long x) {
    int ng = -1;
    int ok = a.length;
    while (Math.abs(ok - ng) > 1) {
      int mi = (ok + ng) / 2;
      if (a[mi] > x) {
        ok = mi;
      } else {
        ng = mi;
      }
    }
    return ok;
  }

  private int bisectLeft(long[] a, long x) {
    int ng = -1;
    int ok = a.length;
    while (Math.abs(ok - ng) > 1) {
      int mi = (ok + ng) / 2;
      if (a[mi] >= x) {
        ok = mi;
      } else {
        ng = mi;
      }
    }
    return ok;
  }


}
