# @param {String} s
# @param {String} t
# @return {Character}
def find_the_difference(s, t)
    a1 = s.chars.tally
    a2 = t.chars.tally
    ('a'..'z').find{ a1[_1] != a2[_1]}
end
