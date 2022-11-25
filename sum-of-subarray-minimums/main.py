from typing import List


class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        arr = [0]+arr
        result = [0]*len(arr)
        stack = [0]
        for i in range(len(arr)):
            while arr[stack[-1]] > arr[i]:
                stack.pop()
            j = stack[-1]
            result[i] = result[j]+(i-j)*arr[i]
            stack.append(i)
        return sum(result)%(10**9+7)

if __name__ == '__main__':
    print(Solution().sumSubarrayMins([3,1,2,4]))
    print(Solution().sumSubarrayMins([11,81,94,43,3]))