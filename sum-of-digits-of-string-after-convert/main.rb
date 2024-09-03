# @param {String} s
# @param {Integer} k
# @return {Integer}
def get_lucky(s, k)
    (k-1).times.reduce(s.chars.flat_map{(_1.ord-96).digits}.sum){_1.digits.sum}
end
