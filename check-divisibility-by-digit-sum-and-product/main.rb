# frozen_string_literal: true

# @param {Integer} n
# @return {Boolean}
def check_divisibility(n)
  n % (n.digits.sum + n.digits.reduce(:*)) == 0
end