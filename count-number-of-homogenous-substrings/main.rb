# @param {String} s
# @return {Integer}
def count_homogenous(s)
    pre = ""
    sum = 0
    count = 1
    s.chars.each do |cur|
        if pre==cur
            count+=1
        else
            count=1
        end
        pre = cur
        sum += count
        sum %= 10**9+7
    end
    sum
end
