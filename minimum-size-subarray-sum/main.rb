# @param {Integer} target
# @param {Integer[]} nums
# @return {Integer}
def min_sub_array_len(target, nums)
  n = nums.size
  d = Array.new(n+1, 0)
  (0...n).each{|i| d[i+1] = d[i] + nums[i]}

  ret = Float::INFINITY
  (0...n).each do |i|
    ok = n
    ng = -1
    while (ok-ng).abs > 1
      mi = (ok+ng)/2
      if d[mi] >= (d[i]+target)
        ok = mi
      else
        ng = mi
      end
    end

    ret = [ret, ok-i].min if d[ok]-d[i] >= target
  end

  ret==Float::INFINITY ? 0 : ret
end

p min_sub_array_len(7, [2,3,1,2,4,3])
p min_sub_array_len(4, [1,4,4])
p min_sub_array_len(11, [1,1,1,1,1,1,1,1])
p min_sub_array_len(11, [1,2,3,4,5])