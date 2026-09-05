# frozen_string_literal: true

# @param {String} num
# @return {Boolean}
def sum_game(num)
  return true if num.count('?').odd?

  n = num.size
  l = num[..n/2-1]
  r = num[n/2..]

  sum_l = l.chars.filter_map{|ch| ch.to_i if ch != '?'}.sum
  sum_r = r.chars.filter_map{|ch| ch.to_i if ch != '?'}.sum
  q_l = l.count('?')
  q_r = r.count('?')
  sum_l - sum_r != (q_r - q_l) / 2 * 9
end