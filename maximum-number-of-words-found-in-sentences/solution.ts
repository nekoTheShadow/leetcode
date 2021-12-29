function mostWordsFound(sentences: string[]): number {
   return Math.max(...sentences.map((sentence) => sentence.split(" ").length))
};

console.log(mostWordsFound(["alice and bob love leetcode", "i think so too", "this is great thanks very much"]))
console.log(mostWordsFound(["please wait", "continue to fight", "continue to win"]))