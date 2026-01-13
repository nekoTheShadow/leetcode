def check(squares: list[tuple[float, float, float]], mi: float) -> bool:
    a1 = 0  # miより下
    a2 = 0  # miより上
    for _, y, l in squares:
        if mi < y:
            a2 += l**2
        elif y <= mi <= y + l:
            a2 += (y + l - mi) * l
            a1 += (mi - y) * l
        else:
            a1 += l**2
    return a1 < a2


class Solution:
    def separateSquares(self, squares: list[list[int]]) -> float:
        sqaure_list = [
            (
                float(square[0]),
                float(square[1]),
                float(square[2]),
            )
            for square in squares
        ]

        ok = float(-1)
        ng = float(10**9 * 2 + 1)
        for _ in range(100):
            mi = (ok + ng) / 2
            if check(sqaure_list, mi):
                ok = mi
            else:
                ng = mi
        return float(ok)


if __name__ == "__main__":
    squares = [[0, 0, 1], [2, 2, 1]]
    print(Solution().separateSquares(squares))
