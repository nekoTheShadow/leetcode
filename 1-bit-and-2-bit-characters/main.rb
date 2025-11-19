# @param {Integer[]} bits
# @return {Boolean}
def is_one_bit_character(bits)
  check(bits, 0)
end

def check(bits, x)
  return false if bits.size <= x
  return bits[x] == 0 if x == bits.size - 1
  
  if bits[x] == 0
    check(bits, x + 1)
  else
    check(bits, x + 2) 
  end
end


require "minitest/autorun"

describe "is_one_bit_character" do
  it "example1" do
    _(is_one_bit_character [1,0,0]).must_equal true
  end

  it "example2" do
    _(is_one_bit_character [1,1,1,0]).must_equal false
  end
end
