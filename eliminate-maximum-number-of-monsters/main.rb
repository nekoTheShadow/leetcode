# @param {Integer[]} dist
# @param {Integer[]} speed
# @return {Integer}
def eliminate_maximum(dist, speed)
    ans = 0
    dist.zip(speed).map{_1.quo(_2)}.sort.each do |arrival|
        break if arrival <= ans
        ans += 1
    end
    ans
end
