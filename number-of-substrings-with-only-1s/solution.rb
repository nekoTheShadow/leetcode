# @param {String} s
# @return {Integer}
def num_sub(s)
  total = 0
  s.scan(/1+/) do |t|
    n = t.size
    total += (1 + n) * n / 2
    total %= 10**9 + 7
  end
  total
end