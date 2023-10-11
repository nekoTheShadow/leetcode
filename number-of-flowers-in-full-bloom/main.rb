# @param {Integer[][]} flowers
# @param {Integer[]} people
# @return {Integer[]}
def full_bloom_flowers(flowers, people)
  imos = Hash.new{|h, k| h[k] = 0}
  flowers.each do |s, e|
    imos[s] += 1
    imos[e+1] -= 1
  end
  imos = imos.sort_by{|k, v| k}
  
  count = 0
  cur = 0
  ans = Array.new(people.size)
  people.map.with_index{|person, i| [person, i]}.sort_by(&:first).each do |person, i|
    while cur < imos.size && imos[cur][0] <= person
      count += imos[cur][1]
      cur += 1
    end
    ans[i] = count
  end
  ans
end
