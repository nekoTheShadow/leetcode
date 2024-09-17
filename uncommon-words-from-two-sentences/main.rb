# @param {String} s1
# @param {String} s2
# @return {String[]}
def uncommon_from_sentences(s1, s2)
    t1 = s1.split(' ').tally
    t2 = s2.split(' ').tally
    t1.filter_map{|k, v| k if v==1 && !t2.key?(k)} + t2.filter_map{|k, v| k if v==1 && !t1.key?(k)}
end
