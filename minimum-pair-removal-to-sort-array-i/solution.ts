import _ from "lodash";

export function minimumPairRemoval(nums: number[]): number {
  let count = 0;
  while (!isSorted(nums)) {
    nums = merge(nums);
    count++;
  }
  return count;
}

function merge(nums: number[]): number[] {
  let x = 0;
  for (let i = 0; i < nums.length - 1; i++) {
    if (nums[i] + nums[i + 1] < nums[x] + nums[x + 1]) {
      x = i;
    }
  }
  return [...nums.slice(0, x), nums[x] + nums[x + 1], ...nums.slice(x + 2)];
}

function isSorted(nums: number[]): boolean {
  for (let i = 0; i < nums.length - 1; i++) {
    if (!(nums[i] <= nums[i + 1])) {
      return false;
    }
  }
  return true;
}
