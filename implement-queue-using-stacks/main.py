class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        self.s1.append(x)

    def pop(self) -> int:
        self._clean()
        return self.s2.pop()

    def peek(self) -> int:
        self._clean()
        return self.s2[-1]

    def empty(self) -> bool:
        return len(self.s1) == 0 and len(self.s2) == 0

    def _clean(self) -> None:
        if len(self.s2) > 0:
            return 
        while self.s1:
            self.s2.append(self.s1.pop())

