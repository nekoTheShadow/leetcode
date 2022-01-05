function firstUniqChar(s: string): number {
    const chars = s.split("")
    const counter = chars.reduce((d, ch) => d.set(ch, (d.get(ch) || 0) + 1), new Map<string, number>())
    for (let i = 0, len = chars.length; i < len; i++) {
        if (counter.get(chars[i]) == 1) return i
    }
    return -1
};

console.log(firstUniqChar("leetcode")) //=> 0
console.log(firstUniqChar("loveleetcode")) //=> 2
console.log(firstUniqChar("aabb")) //=> -1