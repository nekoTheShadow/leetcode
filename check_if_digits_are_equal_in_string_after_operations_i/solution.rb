# @param {String} s
# @return {Boolean}
def has_same_digits(s)
    s = s.chars.map(&:to_i).each_cons(2).map{(_1+_2)%10}.join while s.size > 2
    s[0] == s[1]
end 