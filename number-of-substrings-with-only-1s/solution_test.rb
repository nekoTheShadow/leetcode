require "minitest/autorun"
require "./solution"

describe "num_sub" do
  it "example1" do
    expect(num_sub("0110111")).must_equal 9
  end

  it "example2" do
    expect(num_sub("101")).must_equal 2
  end
  
  it "example3" do
    expect(num_sub("111111")).must_equal 21
  end
end