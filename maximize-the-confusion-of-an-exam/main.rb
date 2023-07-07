# @param {String} answer_key
# @param {Integer} k
# @return {Integer}
def max_consecutive_answers(answer_key, k)
  [solve(answer_key, k), solve(answer_key.tr("TF", "FT"), k)].max
end

def solve(answer_key, k)
  n = answer_key.size
  left = 0
  right = 0
  ret = 0
  while left < n
    while right<n && (answer_key[right]=='T' || k>0)
      k -= 1 if answer_key[right]=='F'
      right += 1
    end

    ret = [ret, right-left].max

    if left==right
      right += 1
    else
      k += 1 if answer_key[left]=='F'
    end

    left += 1
  end

  ret
end

p max_consecutive_answers("TTFF", 2)
p max_consecutive_answers("TFFT", 1)
p max_consecutive_answers("TTFTTFTT", 1)
