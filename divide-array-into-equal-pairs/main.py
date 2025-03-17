class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        import collections
        return all(v % 2 == 0 for v in collections.Counter(nums).values())
