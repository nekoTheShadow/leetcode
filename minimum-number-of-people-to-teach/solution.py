class Solution:
    def minimumTeachings(self, n: int, languages: list[list[int]], friendships: list[list[int]]) -> int:
        languages: list[set[int]] = [set(language) for language in languages]

        students: set[int] = set()
        for friendship in friendships:
            u = friendship[0] - 1
            v = friendship[1] - 1
            if languages[u].isdisjoint(languages[v]):
                students.add(u)
                students.add(v)
        
        ans = 10**9
        for language in range(1, n + 1):
            count = 0
            for student in students:
                if not language in languages[student]:
                    count += 1
            ans = min(ans, count)
        return ans
