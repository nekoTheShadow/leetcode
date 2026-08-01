require "minitest/autorun"
require "./main"

describe "3518. Smallest Palindromic Rearrangement II" do
  it "Example 1" do
    s = "abba"
    k = 2
    output = "baab"
    _(smallest_palindrome(s, k)).must_equal output
  end
  it "Example 2" do
    s = "aa"
    k = 2
    output = ""
    _(smallest_palindrome(s, k)).must_equal output
  end
  it "Example 3" do
    s = "bacab"
    k = 1
    output = "abcba"
    _(smallest_palindrome(s, k)).must_equal output
  end
end