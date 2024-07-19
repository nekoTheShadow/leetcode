# @param {Integer[][]} matrix
# @return {Integer[]}
def lucky_numbers (matrix)
    matrix.map(&:min) & matrix.transpose.map(&:max)
end
