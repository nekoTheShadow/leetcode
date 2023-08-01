# @param {Integer} n
# @param {Integer} k
# @return {Integer[][]}
def combine(n, k)
    return [] if n==0 || k==0
    return (1..n).map{|v| [v]} if k==1
    [*combine(n-1, k-1).map{|b| [*b, n]}, *combine(n-1, k)]
end
