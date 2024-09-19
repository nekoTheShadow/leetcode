# @param {String} expression
# @return {Integer[]}
def diff_ways_to_compute(expression)
    return [expression.to_i] if expression =~ /^[0-9]*$/

    n = expression.size
    answers = []
    (0...n).each do |i|
        v = expression[i]
        next if v =~ /[0-9]/

        xs = diff_ways_to_compute(expression[0...i])
        ys = diff_ways_to_compute(expression[i+1...n])
        xs.product(ys) do |x, y|
            answers << x + y if v == '+'
            answers << x - y if v == '-'
            answers << x * y if v == '*'
        end
    end
    answers
end
