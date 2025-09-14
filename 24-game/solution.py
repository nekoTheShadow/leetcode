import fractions
import itertools
from typing import Iterator


def generate_rpn(
    cards: list[str], stack: list[str], i: int, operand: int, operator: int
) -> Iterator[list[str]]:
    if operand == 4 and operator == 3:
        yield stack

    if operand > operator + 1:
        for v in "+*-/":
            stack.append(v)
            yield from generate_rpn(cards, stack, i, operand, operator + 1)
            stack.pop()

    if i < 4:
        stack.append(cards[i])
        yield from generate_rpn(cards, stack, i + 1, operand + 1, operator)
        stack.pop()


def calc_rpn(statement: list[str]) -> int | None:
    stack: list[fractions.Fraction] = []
    for v in statement:
        if v.isdigit():
            stack.append(fractions.Fraction(int(v)))
        else:
            y = stack.pop()
            x = stack.pop()
            if v == "+":
                stack.append(x + y)
            if v == "-":
                stack.append(x - y)
            if v == "*":
                stack.append(x * y)
            if v == "/":
                if y == 0:
                    return None
                else:
                    stack.append(x / y)
    return stack[0]


class Solution:
    def judgePoint24(self, cards: list[int]) -> bool:
        for pattern in itertools.permutations(map(str, cards)):
            for rpn in generate_rpn(pattern, [], 0, 0, 0):
                if calc_rpn(rpn) == 24:
                    return True
        return False
