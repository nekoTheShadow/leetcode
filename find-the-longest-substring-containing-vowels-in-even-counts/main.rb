# @param {String} s
# @return {Integer}
def find_the_longest_substring(s)
    map = {0 => -1}
    mask = 0
    ret = 0
    s.chars.each_with_index do |ch, i|
        mask ^= (1 << 0) if ch=='a'
        mask ^= (1 << 1) if ch=='i'
        mask ^= (1 << 2) if ch=='u'
        mask ^= (1 << 3) if ch=='e'
        mask ^= (1 << 4) if ch=='o'

        if map.key?(mask)
            ret = [ret, i - map[mask]].max
        else
            map[mask] = i
        end
    end
    ret
end
