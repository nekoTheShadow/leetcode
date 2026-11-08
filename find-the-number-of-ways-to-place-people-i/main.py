from typing import List


class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        n = len(points)
        ans = 0

        for i in range(n):
            for j in range(n):
                if i == j:
                    continue

                x1, y1 = points[i]
                x2, y2 = points[j]

                # AがBの左上にあるか？
                if not (x1 <= x2 and y1 >= y2):
                    continue

                # 長方形の中にほかの点があるか?
                has_other_points = False
                for k in range(n):
                    if k == i or k == j:
                        continue
                    x3, y3 = points[k]
                    if min(x1, x2) <= x3 <= max(x1, x2) and min(y1, y2) <= y3 <= max(
                        y1, y2
                    ):
                        has_other_points = True
                        break

                if not has_other_points:
                    ans += 1

        return ans
