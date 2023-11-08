# @param {Integer} sx
# @param {Integer} sy
# @param {Integer} fx
# @param {Integer} fy
# @param {Integer} t
# @return {Boolean}
def is_reachable_at_time(sx, sy, fx, fy, t)
    a = (sx-fx).abs
    b = (sy-fy).abs
    return false if a==0 && b==0 && t==1
    return [a,b].max <= t
end
