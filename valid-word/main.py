class Solution:
    def isValid(self, word: str) -> bool:
        def is_vowel(ch: str) -> bool:
            return ch in "aiueoAIUEO"

        def is_consonant(ch: str) -> bool:
            return ch.isalpha() and not is_vowel(ch)

        return (
            len(word) >= 3
            and all(ch.isalnum() for ch in word)
            and any(is_vowel(ch) for ch in word)
            and any(is_consonant(ch) for ch in word)
        )
