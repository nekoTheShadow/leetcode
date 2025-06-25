package kth_smallest_product_of_two_sorted_arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

  Solution s;

  @BeforeEach
  void setup() {
    s = new Solution();
  }

  @Test
  void example1() {
    int[] nums1 = new int[] {2, 5};
    int[] nums2 = new int[] {3, 4};
    long k = 2;
    long output = 8;
    assertEquals(output, s.kthSmallestProduct(nums1, nums2, k));
  }


  @Test
  void example2() {
    int[] nums1 = new int[] {-4, -2, 0, 3};
    int[] nums2 = new int[] {2, 4};
    long k = 6;
    long output = 0;
    assertEquals(output, s.kthSmallestProduct(nums1, nums2, k));
  }

  @Test
  void example3() {
    int[] nums1 = new int[] {-2, -1, 0, 1, 2};
    int[] nums2 = new int[] {-3, -1, 2, 4, 5};
    long k = 3;
    long output = -6;
    assertEquals(output, s.kthSmallestProduct(nums1, nums2, k));
  }
}
