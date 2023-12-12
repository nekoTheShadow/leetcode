#include <stdio.h>

int maxProduct(int* nums, int numsSize) {
    int v1 = 0;
    int v2 = 0;
    for (int i=0; i<numsSize; i++) {
        if (v1<nums[i]) {
            v2 = v1;
            v1 = nums[i];
        } else if (v2<=nums[i]) {
            v2 = nums[i];
        }
    }
    return (v1-1)*(v2-1);
}

int main(int argc, char* argv[]) {
    int nums1[] = {3,4,5,2}; 
    printf("%d\n", maxProduct(nums1, sizeof(nums1)/sizeof(int)));

    int nums2[] = {1,5,4,5}; 
    printf("%d\n", maxProduct(nums2, sizeof(nums2)/sizeof(int)));

    int nums3[] = {3,7}; 
    printf("%d\n", maxProduct(nums3, sizeof(nums3)/sizeof(int)));

    int nums4[] = {10,2,5,2};
    printf("%d\n", maxProduct(nums4, sizeof(nums4)/sizeof(int)));

    return 0;
}