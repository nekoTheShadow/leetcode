class Solution:
    def kthCharacter(self, k: int) -> str:
        word = "a"
        while len(word) < k:
            word += "".join(self.next_character(ch) for ch in word)
        return word[k - 1]

    def next_character(self, ch: str) -> str:
        if ch == "z":
            return "a"
        else:
            return chr(ord(ch) + 1)
