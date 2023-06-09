# @param {Character[]} letters
# @param {Character} target
# @return {Character}
def next_greatest_letter(letters, target)
    letters.bsearch{|v| target < v} || letters[0]
end
