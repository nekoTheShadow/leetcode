def max_score(nums1, nums2, k)
  n = nums1.size
  pairs = nums1.zip(nums2).sort_by{|num1, num2| -num2}

  heap = pairs[0...k].map{|num1, num2| num1}.sort
  sum = heap.sum
  ans = sum * pairs[k-1][1]

  pairs[k...n].each do |num1, num2|
    sum -= heap.shift
    sum += num1

    heap.insert(heap.bsearch_index{|x| x >= num1} || heap.size, num1)
    ans = [ans, sum*num2].max 
  end

  return ans
end

puts max_score([1,3,3,2], [2,1,3,4], 3)
puts max_score([4,2,3,1,1], [7,5,10,9,6], 1)