# @param {String} s
# @return {Integer}
def max_active_sections_after_trade(s)
  mx = ("1" + s + "1").scan(/0+|1+/).each_cons(5).filter_map{|(a, b, c, d, e)| b.size + d.size if a.start_with?("1")}.max
  s.count("1") + (mx || 0)
end