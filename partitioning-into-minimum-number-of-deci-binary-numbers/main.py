class Solution:
    def minPartitions(self, n: str) -> int:
        return int(max(n))

if __name__ == '__main__':
    print(Solution().minPartitions("32"))
    print(Solution().minPartitions("82734"))
    print(Solution().minPartitions("27346209830709182346"))