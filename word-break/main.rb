# @param {String} s
# @param {String[]} word_dict
# @return {Boolean}
def word_break(s, word_dict)
    n = s.size
    dp = Array.new(n+1, false)
    dp[0] = true
    (0..n).each do |i|
        next unless dp[i]
        word_dict.each do |word|
            next unless s[i...i+word.size] == word
            dp[i+word.size] = true
        end
    end
    dp[n]
end
