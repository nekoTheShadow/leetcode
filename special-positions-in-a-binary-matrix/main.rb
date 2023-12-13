# @param {Integer[][]} mat
# @return {Integer}
def num_special(mat)
    require 'set'
    h = mat.size
    w = mat[0].size
    [*0...h].product([*0...w]).count do |(x, y)|
        mat[x][y]==1 && 
            (0...h).sum{|i| mat[i][y]}==1 && 
            (0...w).sum{|j| mat[x][j]}==1
    end
end
