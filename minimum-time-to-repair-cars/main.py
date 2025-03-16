class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        import math

        def is_ok(m: int) -> bool:
            return cars <= sum(int(math.sqrt(m / rank)) for rank in ranks)
        
        ng = 0
        ok = max(ranks) * cars * cars + 1
        while abs(ok - ng) > 1:
            mi = (ok + ng) // 2
            if is_ok(mi):
                ok = mi
            else:
                ng = mi
        return ok
