import bisect
import collections


class Router:

    def __init__(self, memory_limit: int):
        self.memory_limit = memory_limit
        self.q: collections.deque[tuple[int, int, int]] = collections.deque()
        self.s: set[tuple[int, int, int]] = set()
        # key = destination, value = list[timestamp]
        self.t: collections.defaultdict[int, collections.deque[int]] = (
            collections.defaultdict(collections.deque)
        )

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        new_entry = (source, destination, timestamp)
        if new_entry in self.s:
            return False

        self.q.append(new_entry)
        self.s.add(new_entry)
        self.t[destination].append(timestamp)
        if len(self.q) > self.memory_limit:
            self.forwardPacket()
        return True

    def forwardPacket(self) -> list[int]:
        if len(self.q) == 0:
            return []
        (source, destination, timestamp) = self.q.popleft()
        self.s.remove((source, destination, timestamp))
        self.t[destination].popleft()
        return [source, destination, timestamp]

    def getCount(self, destination: int, start_time: int, end_time: int) -> int:
        if not destination in self.t:
            return 0

        l = bisect.bisect_left(self.t[destination], start_time)
        r = bisect.bisect_right(self.t[destination], end_time)
        return r - l
