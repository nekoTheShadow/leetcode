# @param {Integer[][]} coordinates
# @return {Boolean}
def check_straight_line(coordinates)
    n = coordinates.length
    (2...n).each do |i|
        return false if (coordinates[0][1]-coordinates[1][1]) * (coordinates[0][0]-coordinates[i][0]) != (coordinates[0][0]-coordinates[1][0]) * (coordinates[0][1]-coordinates[i][1])
    end
    true
end
