# @param {Integer[]} arr
# @param {Integer} k
# @return {Boolean}
def can_arrange(arr, k)
    c = Array.new(k, 0)
    arr.each{|v| c[v%k]+=1}
    (0..k/2).all?{|i| (i==0 || i==k-i) ? c[i].even? : c[i]==c[k-i] }
end
