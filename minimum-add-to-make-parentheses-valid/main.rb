# @param {String} s
# @return {Integer}
def min_add_to_make_valid(s)
    stack = 0
    count = 0
    s.chars.each do |c|
        if c == '('
            stack += 1
        else
            if stack == 0
                count += 1
            else
                stack -= 1
            end
        end
    end
    count + stack
end
