import functools


class Solution:
    def soupServings(self, n: int) -> float:
        def roundup(a: int) -> int:
            return max(a, 0)

        @functools.cache
        def f(a: int, b: int) -> float:
            if a == 0 and b > 0:
                return 1
            if a == 0 and b == 0:
                return 0.5
            if a > 0 and b == 0:
                return 0

            return (
                f(roundup(a - 100), b) * 0.25
                + f(roundup(a - 75), roundup(b - 25)) * 0.25
                + f(roundup(a - 50), roundup(b - 50)) * 0.25
                + f(roundup(a - 25), roundup(b - 75)) * 0.25
            )

        if n > 4800:
            return 1
        return f(n, n)
