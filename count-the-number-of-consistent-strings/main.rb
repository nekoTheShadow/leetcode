# @param {String} allowed
# @param {String[]} words
# @return {Integer}
def count_consistent_strings(allowed, words)
    pattern = Regexp.compile("^[#{allowed}]*$")
    words.count{pattern.match?(_1)}
end
