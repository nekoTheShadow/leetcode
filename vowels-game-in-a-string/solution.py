class Solution:
    def doesAliceWin(self, s: str) -> bool:
        d = 0
        for ch in s:
            if ch in "aiueo":
                d += 1

        # 文字列sに含まれている母音の数が0個の場合、Bobの勝ち
        if d == 0:
            return False

        # 文字列sに含まれている母音の数が奇数個の場合、Aliceの勝ち
        if d % 2 != 0:
            return True

        # 文字列sに含まれている母音の数が偶数個の場合
        # Aliceがとりうる戦略をすべて試して、ひとつでも勝ち筋があれば
        # Aliceの勝ち、それ以外はBobの勝ち
        e = 0
        for i in range(1, len(s) + 1):
            if s[i] in "aiueo":
                e += 1
            if e % 2 != 0:
                if self.doesAliceWin(s[i:]):
                    return True
        return False
