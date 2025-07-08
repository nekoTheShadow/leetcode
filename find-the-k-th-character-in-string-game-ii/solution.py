import itertools
from typing import List


class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        history: list[int] = []
        v = bin(k - 1)[2:]
        while v:
            history.append(int(v, base=2))
            v = v[1:]
        history.reverse()

        d = 1 if history[0] == 1 and operations[0] == 1 else 0
        for (v1, v2), op in zip(itertools.pairwise(history), operations[1:]):
            if v1 != v2 and op == 1:
                d += 1
        return chr(ord("a") + (d % 26))
