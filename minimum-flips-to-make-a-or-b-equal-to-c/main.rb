# @param {Integer} a
# @param {Integer} b
# @param {Integer} c
# @return {Integer}
def min_flips(a, b, c)
    ans = 0
    (0..30).each do |i|
        x, y, z = a[i], b[i], c[i]
        ans += 1 if x==1 && y==0 && z==0
        ans += 1 if x==0 && y==1 && z==0
        ans += 1 if x==0 && y==0 && z==1
        ans += 2 if x==1 && y==1 && z==0
    end
    ans
end
