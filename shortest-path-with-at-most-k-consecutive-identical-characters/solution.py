import heapq
import unittest

INF = 10**9 + 7


class Solution:
    def shortestPath(self, n: int, edges: list[list[int]], labels: str, k: int) -> int:
        graph: list[list[tuple[int, int]]] = [[] for _ in range(n)]  # (to, weight)
        for edge in edges:
            graph[edge[0]].append((edge[1], edge[2]))

        costs = [[INF] * (k + 1) for _ in range(n)]
        costs[0][1] = 0
        pq: list[tuple[int, int, int]] = []
        heapq.heappush(pq, (0, 0, 1))  # (cost, pos, rep)

        while pq:
            cost, pos, rep = heapq.heappop(pq)
            if costs[pos][rep] < cost:
                continue

            for next_pos, weight in graph[pos]:
                next_cost = cost + weight
                next_label = labels[next_pos]
                next_rep = rep + 1 if labels[pos] == next_label else 1
                if next_rep <= k and next_cost < costs[next_pos][next_rep]:
                    costs[next_pos][next_rep] = next_cost
                    heapq.heappush(pq, (next_cost, next_pos, next_rep))

        if (ans := min(costs[n - 1])) == INF:
            return -1
        else:
            return ans


class SolutionTest(unittest.TestCase):
    def test_example1(self):
        n = 3
        edges = [[0, 1, 1], [1, 2, 1], [0, 2, 3]]
        labels = "aab"
        k = 1
        self.assertEqual(Solution().shortestPath(n, edges, labels, k), 3)

    def test_example2(self):
        n = 3
        edges = [[0, 1, 1], [1, 2, 1], [0, 2, 3]]
        labels = "aab"
        k = 2
        self.assertEqual(Solution().shortestPath(n, edges, labels, k), 2)

    def test_example3(self):
        n = 3
        edges = [[0, 1, 1], [1, 2, 1]]
        labels = "aaa"
        k = 2
        self.assertEqual(Solution().shortestPath(n, edges, labels, k), -1)


if __name__ == "__main__":
    unittest.main()
