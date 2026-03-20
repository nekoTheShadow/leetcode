import itertools
from typing import Optional
import unittest


class Solution:
    def getBiggestThree(self, grid: list[list[int]]) -> list[int]:
        self.grid = grid
        self.h = len(grid)
        self.w = len(grid[0])

        rhombus_sums: set[int] = set()
        for x, y in itertools.product(range(self.h), range(self.w)):
            rhombus_sums.add(grid[x][y])
            d = 1
            while rhombus_sum := self.get_rhombus_sum(x, y, d):
                rhombus_sums.add(rhombus_sum)
                d += 1
        return list(sorted(rhombus_sums, reverse=True))[:3]

    def get_rhombus_sum(self, x: int, y: int, d: int) -> Optional[int]:
        st: set[tuple[int, int]] = set()
        for i in range(0, d):
            j = d - i
            st.add((i, j))
            st.add((-i, j))
            st.add((i, -j))
            st.add((-i, -j))
            st.add((j, i))
            st.add((-j, i))
            st.add((j, -i))
            st.add((-j, -i))

        total = 0
        for dx, dy in st:
            if 0 <= x + dx < self.h and 0 <= y + dy < self.w:
                total += self.grid[x + dx][y + dy]
            else:
                return None
        return total


class TestSolution(unittest.TestCase):
    def test_example1(self):
        grid = [
            [3, 4, 5, 1, 3],
            [3, 3, 4, 2, 3],
            [20, 30, 200, 40, 10],
            [1, 5, 5, 4, 1],
            [4, 3, 2, 2, 5],
        ]
        output = [228, 216, 211]
        self.assertEqual(Solution().getBiggestThree(grid), output)

    def test_example2(self):
        grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        output = [20, 9, 8]
        self.assertEqual(Solution().getBiggestThree(grid), output)

    def test_example3(self):
        grid = [[7, 7, 7]]
        output = [7]
        self.assertEqual(Solution().getBiggestThree(grid), output)
