# @param {Integer[]} skill
# @return {Integer}
def divide_players(skill)
    n = skill.size
    target, mod = skill.sum.divmod(n/2)
    return -1 if mod > 0

    counter = skill.tally
    chemistry = 0
    counter.each do |x, c|
        y = target - x
        return -1 if counter[x] != counter[y]
        chemistry += x*y*c
    end
    chemistry/2
end
