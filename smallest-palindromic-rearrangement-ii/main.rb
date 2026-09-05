# @param {String} s
# @param {Integer} k
# @return {String}
def smallest_palindrome(s, k)
  freq = s.chars.tally

  half_freq = Hash.new(0)
  odd_ch = ""
  freq.each do |ch, count|
    half_freq[ch] = count / 2 if count > 1
    odd_ch = ch if count.odd?
  end

  n = half_freq.values.sum
  perms = (1..n).reduce(1, :*) / half_freq.values.map{|count| (1..count).reduce(1, :*)}.reduce(1, :*)
  
  return "" if perms < k

  left = []
  while n > 0
    ('a'..'z').each do |ch|
      next if half_freq[ch] == 0

      sub_perms = perms * half_freq[ch] / n
      if sub_perms >= k
        left << ch
        perms = sub_perms
        half_freq[ch] -= 1
        n -= 1
        break 
      else 
        k -= sub_perms
      end
    end
  end

  [*left, odd_ch, *left.reverse].join
end

