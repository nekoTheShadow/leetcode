# @param {Integer[][]} grid
# @return {Integer}
def equal_pairs(grid)
    h = grid.tally
    grid.transpose.sum{|col| h[col] || 0}
end
