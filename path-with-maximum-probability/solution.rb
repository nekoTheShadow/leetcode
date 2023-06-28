# @param {Integer} n
# @param {Integer[][]} edges
# @param {Float[]} succ_prob
# @param {Integer} start
# @param {Integer} end
# @return {Float}
def max_probability(n, edges, succ_prob, start, goal)
    g = Array.new(n){ Array.new }
    edges.zip(succ_prob).each do |(x, y), v|
        g[x] << [y, v]
        g[y] << [x, v]
    end

    cost = Array.new(n, 0)
    cost[start] = 1

    que = [start]
    until que.empty?
        cur = que.shift
        g[cur].each do |nxt, v|
            if cost[nxt] < cost[cur]*v
                cost[nxt] = cost[cur]*v
                que << nxt
            end  
        end
    end

    cost[goal]
end
