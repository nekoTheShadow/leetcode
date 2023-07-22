# @param {Integer} n
# @param {Integer} k
# @param {Integer} row
# @param {Integer} column
# @return {Float}
def knight_probability(n, k, row, column)
    diffs = [
        [1,2], [1,-2], [-1,2], [-1,-2],
        [2,1], [2,-1], [-2,1], [-2,-1]
    ]
    dp = Array.new(n){Array.new(n){Array.new(k+1, 0.0)}}
    dp[row][column][0] = 1.0

    (0...k).each do |c|
        (0...n).each do |x|
            (0...n).each do |y|
                diffs.each do |dx, dy|
                    nx, ny = x+dx, y+dy
                    next unless 0<=nx&&nx<n&&0<=ny&&ny<n
                    dp[nx][ny][c+1] += dp[x][y][c]*0.125
                end
            end
        end
    end
    ret = 0.0
    (0...n).each do |x|
        (0...n).each do |y|
            ret += dp[x][y][k]
        end
    end
    ret
end
