# @param {Integer[]} arr
# @return {Integer[]}
def sort_by_bits(arr) = arr.sort{|n1, n2| [popcount(n1), n1] <=> [popcount(n2), n2]}
def popcount(n) = n.zero? ? 0 : popcount(n/2)+n%2
