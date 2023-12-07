# @param {String} num
# @return {String}
def largest_odd_number(num)
    (i = num.rindex(/[13579]/)) ? num[0..i] : ""
end
