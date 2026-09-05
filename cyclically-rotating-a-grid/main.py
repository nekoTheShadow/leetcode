import collections
from typing import Iterator


class Solution:
    def rotateGrid(self, grid: list[list[int]], k: int) -> list[list[int]]:
        m = len(grid)
        n = len(grid[0])

        for layer in range(min(m, n) // 2):
            cells: collections.deque[int] = collections.deque()

            # 取り出し
            for i, j in self.iter_layer(m, n, layer):
                cells.append(grid[i][j])

            # 回転
            cells.rotate(-k)

            # 書き戻し
            for i, j in self.iter_layer(m, n, layer):
                grid[i][j] = cells.popleft()

        return grid

    def iter_layer(
        self,
        m: int,
        n: int,
        layer: int,
    ) -> Iterator[tuple[int, int]]:
        top = layer
        bottom = m - layer - 1
        left = layer
        right = n - layer - 1

        # 上辺
        for j in range(left, right + 1):
            yield top, j

        # 右辺
        for i in range(top + 1, bottom):
            yield i, right

        # 下辺
        for j in reversed(range(left, right + 1)):
            yield bottom, j

        # 左辺
        for i in reversed(range(top + 1, bottom)):
            yield i, left


if __name__ == "__main__":
    grid = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
    k = 0
    output = [[3, 4, 8, 12], [2, 11, 10, 16], [1, 7, 6, 15], [5, 9, 13, 14]]
    print(Solution().rotateGrid(grid, k))
