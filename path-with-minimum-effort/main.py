import heapq
from typing import List

class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        n, m = len(heights), len(heights[0])
        scores = [[float('inf')]*m for _ in range(n)]
        scores[0][0] = 0
        pq = [(0, 0, 0)]
        while pq:
            score, cur_x, cur_y = heapq.heappop(pq)
            if scores[cur_x][cur_y] < score:
                continue

            for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                next_x, next_y = cur_x + dx, cur_y + dy
                if not (0 <= next_x < n and 0 <= next_y < m):
                    continue
                next_score = max(score, abs(heights[cur_x][cur_y] - heights[next_x][next_y]))
                if next_score < scores[next_x][next_y]:
                    scores[next_x][next_y] = next_score
                    heapq.heappush(pq, (next_score, next_x, next_y))
        return scores[n-1][m-1]

if __name__ == '__main__':
    print(Solution().minimumEffortPath([[1,2,2],[3,8,2],[5,3,5]]))
    print(Solution().minimumEffortPath([[1,2,3],[3,8,4],[5,3,5]]))
    print(Solution().minimumEffortPath([[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]))
    print(Solution().minimumEffortPath([[1,10,6,7,9,10,4,9]]))