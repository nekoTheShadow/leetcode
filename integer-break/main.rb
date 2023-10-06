# @param {Integer} n
# @return {Integer}
def integer_break(n)
    max = 0
    (2..n).each do |k|
        d, m = n.divmod(k)
        v = (0...k).inject(1){|t, i| i<m ? t*(d+1) : t*d}
        max = [max, v].max
    end
    max
end
