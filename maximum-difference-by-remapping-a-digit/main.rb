# @param {Integer} num
# @return {Integer}
def min_max_difference(num)
    digits = num.digits.reverse
    to_max(digits) - to_min(digits)
end

def to_max(digits)
    ignore = digits.find{|digit| digit != 9}
    digits.map{|digit| digit == ignore ? 9 : digit}.reduce(0){|acc, digit| acc * 10 + digit}
end

def to_min(digits)
    ignore = digits[0]
    digits.map{|digit| digit == ignore ? 0 : digit}.reduce(0){|acc, digit| acc * 10 + digit}
end
