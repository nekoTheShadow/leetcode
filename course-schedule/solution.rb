# @param {Integer} num_courses
# @param {Integer[][]} prerequisites
# @return {Boolean}
def can_finish(num_courses, prerequisites)
    g = Array.new(num_courses){ [] }
    c = Array.new(num_courses, 0)
    prerequisites.each do |a, b|
        g[a] << b
        c[b] += 1
    end

    q = (0...num_courses).filter{|i| c[i] == 0}
    ret = []
    until q.empty?
        i = q.shift
        ret << i
        g[i].each do |j|
            c[j] -= 1
            q << j if c[j] == 0
        end
    end

    ret.size == num_courses
end
