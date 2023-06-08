# @param {Integer[][]} grid
# @return {Integer}
def count_negatives(grid)
    grid.flatten.count(&:negative?)
end
