require 'set'

def min_extra_char(s, dictionary)
    @s = s
    @n = s.size
    @d = dictionary.to_set
    @memo = {}
    
    s.size - dfs(0)
end

def dfs(x)
    return 0 if x == @n
    return @memo[x] if @memo.key?(x)
    
    max = dfs(x+1)
    (x...@n).each do |y|
        max = [max, (y-x+1) + dfs(y+1)].max if @d.include?(@s[x..y])
    end
    @memo[x] = max
end
