from dataclasses import dataclass
from typing import List
import unittest


class UnionFind:
    def __init__(self, n: int) -> None:
        self.parents = list(range(n))
        self.components = n

    def find(self, x: int) -> int:
        if x != self.parents[x]:
            self.parents[x] = self.find(self.parents[x])
        return self.parents[x]

    def union(self, x: int, y: int):
        x = self.find(x)
        y = self.find(y)
        if x != y:
            self.parents[x] = y
            self.components -= 1

    def is_same(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)


@dataclass
class Edge:
    u: int
    v: int
    s: int
    must: bool


class Solution:
    def maxStability(self, n: int, edges: List[List[int]], k: int) -> int:
        self.n = n
        self.edges = [Edge(edge[0], edge[1], edge[2], edge[3] == 1) for edge in edges]
        self.k = k

        # must辺だけで閉路チェック
        uf = UnionFind(self.n)
        for edge in self.edges:
            if edge.must:
                if uf.is_same(edge.u, edge.v):
                    return -1
                uf.union(edge.u, edge.v)

        ok = -1
        ng = int(1e10)
        while abs(ok - ng) > 1:
            mi = (ok + ng) // 2
            if self.is_ok(mi):
                ok = mi
            else:
                ng = mi

        return ok

    def is_ok(self, t: int) -> bool:
        # must辺の強度チェック
        for edge in self.edges:
            if edge.must and edge.s < t:
                return False

        uf = UnionFind(self.n)

        # must辺
        for edge in self.edges:
            if edge.must:
                uf.union(edge.u, edge.v)

        # アップグレード不要の辺を先に使う
        for edge in self.edges:
            if not edge.must and edge.s >= t:
                uf.union(edge.u, edge.v)

        # アップグレード必要な辺を使う
        upgrade = 0
        for edge in self.edges:
            if not edge.must and edge.s * 2 >= t and not uf.is_same(edge.u, edge.v):
                uf.union(edge.u, edge.v)
                upgrade += 1

        return upgrade <= self.k and uf.components == 1


class TestSolution(unittest.TestCase):
    def setUp(self) -> None:
        self.solution = Solution()

    def test_example1(self) -> None:
        n = 3
        edges = [[0, 1, 2, 1], [1, 2, 3, 0]]
        k = 1
        output = 2
        self.assertEqual(self.solution.maxStability(n, edges, k), output)

    def test_example2(self) -> None:
        n = 3
        edges = [[0, 1, 4, 0], [1, 2, 3, 0], [0, 2, 1, 0]]
        k = 2
        output = 6
        self.assertEqual(self.solution.maxStability(n, edges, k), output)

    def test_example3(self) -> None:
        n = 3
        edges = [[0, 1, 1, 1], [1, 2, 1, 1], [2, 0, 1, 1]]
        k = 0
        output = -1
        self.assertEqual(self.solution.maxStability(n, edges, k), output)
