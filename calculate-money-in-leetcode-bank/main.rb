# @param {Integer} n
# @return {Integer}
def total_money(n)
    sum = 0
    money = 1
    (1..n).each do |i|
        sum += money
        money = (i%7==0) ? (i/7+1) : (money+1)
    end
    sum
end
