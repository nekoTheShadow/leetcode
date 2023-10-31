# @param {Integer[]} pref
# @return {Integer[]}
def find_array(pref)
    (0...pref.size).map{|i| i==0 ? pref[0] : pref[i-1]^pref[i]}
end
