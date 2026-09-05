# @param {Integer} n
# @param {Integer} t
# @return {Integer}
def smallest_number(n, t) = (n..).find{_1.digits.reduce(:*)%t==0}
