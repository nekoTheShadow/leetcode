# @param {Integer[]} gain
# @return {Integer}
def largest_altitude(gain)
    gain.reduce([0, 0]){|(cur, max), v| [cur+v, [cur+v, max].max]}[1]
end
