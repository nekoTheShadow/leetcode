# @param {Integer[][]} nums
# @return {Integer[]}
def find_diagonal_order(nums)
    a = []
    nums.each_with_index do |row, i|
        row.each_with_index do |v, j|
            a << [i+j, i, j]
        end
    end
    a.sort_by{|ij, i, j| [ij, -i]}.map{|ij, i, j| nums[i][j]}
end
