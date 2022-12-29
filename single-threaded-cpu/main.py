from typing import List

class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        import collections, heapq

        waitings = collections.deque(sorted((task[0], task[1], i) for i, task in enumerate(tasks)))
        que = []
        indexes = []
        cur = 0
        while True:
            while len(waitings) > 0 and waitings[0][0] <= cur:
                enqueue, processing, index = waitings.popleft()
                heapq.heappush(que, (processing, index))
            
            if len(que) > 0:
                processing, index = heapq.heappop(que)
                indexes.append(index)
                cur += processing
            else:
                if len(waitings) > 0:
                    cur = waitings[0][0]
                else:
                    break
        
        return indexes

if __name__ == '__main__':
    print(Solution().getOrder([[1,2],[2,4],[3,2],[4,1]]))
    print(Solution().getOrder([[7,10],[7,12],[7,5],[7,4],[7,2]]))
