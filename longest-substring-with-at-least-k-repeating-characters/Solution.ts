function longestSubstring(s: string, k: number): number {
    const d = s.split("").reduce((d, ch) => d.set(ch, (d.get(ch) || 0) + 1), new Map<string, number>())
    for (const [ch, v] of d) {
        if (v < k) return Math.max(...s.split(ch).map((t) => longestSubstring(t, k)))
    }
    return s.length
};

console.log(longestSubstring("aaabb", 3))
console.log(longestSubstring("ababbc", 2))