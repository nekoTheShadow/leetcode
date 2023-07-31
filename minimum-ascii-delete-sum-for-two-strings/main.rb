# @param {String} s1
# @param {String} s2
# @return {Integer}
def minimum_delete_sum(s1, s2)
    @s1 = s1
    @s2 = s2
    @n1 = s1.size
    @n2 = s2.size
    @memo = Array.new(@n1){Array.new(@n2)}
    @h1 = ('a'..'z').to_h{|k| [k, []]}
    @h2 = ('a'..'z').to_h{|k| [k, []]}
    @s1.chars.each_with_index{|c, i| @h1[c]<<i}
    @s2.chars.each_with_index{|c, i| @h2[c]<<i}

    @a1 = Array.new(@n1+1, 0)
    @a2 = Array.new(@n2+1, 0)
    (0...@n1).each{|i| @a1[i+1] = @a1[i]+@s1[i].ord}
    (0...@n2).each{|i| @a2[i+1] = @a2[i]+@s2[i].ord}

    min = Float::INFINITY
    ('a'..'z').each do |c|
        next if @h1[c].empty? || @h2[c].empty?
        x1 = @h1[c][0]
        x2 = @h2[c][0]

        w1 = @a1[x1]-@a1[0]
        w2 = @a2[x2]-@a2[0]
        min = [min, f(x1, x2)+w1+w2].min
    end
    
    if min==Float::INFINITY
        w1 = @a1[@n1]-@a1[0]
        w2 = @a2[@n2]-@a2[0]
        w1+w2
    else
        min
    end
end

def f(x1, x2)
    return @memo[x1][x2] if @memo[x1][x2]

    min = Float::INFINITY
    ('a'..'z').each do |c|
        y1 = @h1[c].bsearch{|i| i>x1}
        y2 = @h2[c].bsearch{|i| i>x2}
        next if y1.nil? || y2.nil?

        w1 = @a1[y1]-@a1[x1+1]
        w2 = @a2[y2]-@a2[x2+1]
        min = [min, f(y1, y2)+w1+w2].min
    end

    if min == Float::INFINITY
        w1 = @a1[@n1]-@a1[x1+1]
        w2 = @a2[@n2]-@a2[x2+1]
        @memo[x1][x2] = w1+w2
    else
        @memo[x1][x2] = min
    end
    @memo[x1][x2]
end
