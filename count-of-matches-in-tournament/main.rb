# @param {Integer} n
# @return {Integer}
def number_of_matches(n)
    c = 0
    while n > 1
        c += n/2
        n = (n%2==0) ? n/2 : n/2+1
    end
    c
end
