# @param {Integer[][]} matrix
# @param {Integer} target
# @return {Boolean}
def search_matrix(matrix, target)
    m = matrix.size
    n = matrix[0].size
    v = (0...m*n).bsearch do |x|
        i, j = x.divmod(n)
        matrix[i][j] >= target
    end

    return false if v.nil?
    i, j = v.divmod(n)
    matrix[i][j]==target
end
