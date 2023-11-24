# @param {Integer[]} piles
# @return {Integer}
def max_coins(piles)
    piles.sort!
    n = piles.size
    (1..n/3).sum{|i| piles[n-2*i]}
end
