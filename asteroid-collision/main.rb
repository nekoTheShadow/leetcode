# @param {Integer[]} asteroids
# @return {Integer[]}
def asteroid_collision(asteroids)
    stack = []

    asteroids.each do |asteroid|
        if stack.empty? || asteroid > 0
            stack << asteroid
            next
        end

        active = true
        until stack.empty?
            break if stack.last < 0
            if stack.last == asteroid.abs
                stack.pop
                active = false
                break
            elsif stack.last < asteroid.abs
                stack.pop
            else
                active = false
                break
            end
        end
        stack << asteroid if active
    end


    stack
end
