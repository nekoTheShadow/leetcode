# @param {Integer[]} arr
# @return {Integer[]}
def array_rank_transform(arr)
    n = arr.size
    a = (0...n).map{|i| [i, arr[i]]}.sort_by{|i, v| v}

    ranks = Array.new(n)
    rank = 1
    (0...n).each do |x|
        if x == 0
            i, v = a[x]
            ranks[i] = rank 
        else
            i1, v1 = a[x-1]
            i2, v2 = a[x]
            rank += 1 if v1 != v2 
            ranks[i2] = rank
        end
    end
    
    ranks
end
