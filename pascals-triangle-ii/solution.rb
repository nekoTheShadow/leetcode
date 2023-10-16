# @param {Integer} row_index
# @return {Integer[]}
def get_row(row_index)
    a = 1
    b = 1

    ans = []
    (0..row_index).each do |i|
        ans << a/b
        a *= row_index-i
        b *= i+1
    end
    ans
end
