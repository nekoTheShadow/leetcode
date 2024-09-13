# @param {Integer[]} arr
# @param {Integer[][]} queries
# @return {Integer[]}
def xor_queries(arr, queries)
    n = arr.size
    d = Array.new(n+1, 0)
    (0...n).each{|i| d[i+1] = d[i]^arr[i]}
    queries.map{|(l, r)| d[r+1]^d[l]}
end
