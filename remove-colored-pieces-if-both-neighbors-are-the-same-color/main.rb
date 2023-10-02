# @param {String} colors
# @return {Boolean}
def winner_of_game(colors)
    a = b = 0
    (1..colors.size-2).each do |i|
        if colors[i-1]==colors[i] && colors[i]==colors[i+1]
            if colors[i]=='A'
                a += 1
            else
                b += 1
            end
        end
    end
    a > b
end
