# @param {Integer[]} arr
# @return {Integer}
def peak_index_in_mountain_array(arr)
    n = arr.size
    (0...n-1).bsearch{|x| arr[x]>arr[x+1]} || n-1
end
