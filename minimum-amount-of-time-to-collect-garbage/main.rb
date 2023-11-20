# @param {String[]} garbage
# @param {Integer[]} travel
# @return {Integer}
def garbage_collection(garbage, travel)
    ans = 0
    %w(P G M).each do |g|
        last_i = garbage.rindex{ _1.include?(g) } || -1
        (0..last_i).each do |i|
            ans += garbage[i].count(g)
            ans += travel[i] if i != last_i
        end
    end
    ans
end
