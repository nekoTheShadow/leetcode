# @param {String} s
# @return {Boolean}
def repeated_substring_pattern(s)
    n = s.size
    (1...n).each do |i|
        next if n%i!=0
        t = s[0...i]
        return true if s == t*(n/i)
    end
    false
end
