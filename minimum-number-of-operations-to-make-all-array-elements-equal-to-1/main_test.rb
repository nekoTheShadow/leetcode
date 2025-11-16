require "minitest/autorun"
require "./main"

describe "min_operations" do
  it "example1" do
    _(min_operations([2,6,3,4])).must_equal 4
  end

  it "example2" do
    _(min_operations([2,10,6,14])).must_equal -1
  end
  
  it "wrong answer" do
    _(min_operations([6,10,15])).must_equal 4
  end
end