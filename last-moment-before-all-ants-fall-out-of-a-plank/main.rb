# @param {Integer} n
# @param {Integer[]} left
# @param {Integer[]} right
# @return {Integer}
def get_last_moment(n, left, right)
    l_max = left.max || 0
    r_max = right.map{n-_1}.max || 0
    [l_max, r_max].max
end
