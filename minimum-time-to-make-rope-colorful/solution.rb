# @param {String} colors
# @param {Integer[]} needed_time
# @return {Integer}
def min_cost(colors, needed_time)
    groups = []
    (0...colors.size).each do |i|
        if i==0 || colors[i-1]!=colors[i]
            groups << [i]
        else
            groups[-1] << i
        end
    end

    ret = 0
    groups.each do |group|
        next if group.size==1
        ret += group.map{|i| needed_time[i]}.sort[0..group.size-2].sum
    end
    ret
end
