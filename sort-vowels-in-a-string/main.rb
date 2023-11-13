# @param {String} s
# @return {String}
def sort_vowels(s)
    q = s.chars.filter{_1=~/[aiueo]/i}.sort
    s.chars.map{_1=~/[aiueo]/i ? q.shift : _1}.join
end
