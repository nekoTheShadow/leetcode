# @param {String} s
# @return {Integer}
def max_difference(s)
  a1, a2 = s.chars.tally.values.partition(&:odd?)
  a1.max - a2.min
end
