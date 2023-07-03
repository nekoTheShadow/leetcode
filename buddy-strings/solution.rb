# @param {String} s
# @param {String} goal
# @return {Boolean}
def buddy_strings(s, goal)
    return false if s.size != goal.size

    a = (0...s.size).filter{|i| s[i]!=goal[i]}
    if a.size==0
        s.chars.tally.any?{|k, v| v > 1}
    elsif a.size==2
        s[a[0]], s[a[1]] = s[a[1]], s[a[0]]
        s==goal
    else
        false
    end
end
