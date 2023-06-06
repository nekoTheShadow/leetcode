# @param {Integer[]} arr
# @return {Boolean}
def can_make_arithmetic_progression(arr)
    arr.sort!
    n = arr.length
    
    d = arr[0]-arr[1]
    (0...n-1).each do |i|
        return false if arr[i]-arr[i+1] != d
    end
    true
end
