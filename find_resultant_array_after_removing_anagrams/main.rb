# @param {String[]} words
# @return {String[]}
def remove_anagrams(words)
    words.each_with_object([]){|word, stack| stack << word unless !stack.empty? && stack[-1].chars.sort == word.chars.sort}
end