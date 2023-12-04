# @param {String} num
# @return {String}
def largest_good_integer(num)
  (0..num.size-3).filter_map{|i| num[i..i+2] if num[i]==num[i+1] && num[i+1]==num[i+2]}.max || ""
end
