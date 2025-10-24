# @param {Integer} n
# @return {Integer}
def next_beautiful_number(n)
    x = n + 1
    x += 1 until x.digits.tally.all?{_1 == _2}
    x
end
