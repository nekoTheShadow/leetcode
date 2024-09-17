# @param {String[]} time_points
# @return {Integer}
def find_min_difference(time_points)
    minutes = time_points.map{|t|
        h, m = t.split(':').map(&:to_i)
        h*60 + m
    }.sort
    minutes << minutes[0]+24*60
    minutes.each_cons(2).map{|m1, m2| m2-m1}.min
end
