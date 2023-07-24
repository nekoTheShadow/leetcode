# @param {Float} x
# @param {Integer} n
# @return {Float}
def my_pow(x, n)
    return my_pow(1/x, -n) if n<0
    return 1.0 if n==0
    return x if n==1

    n.even? ? my_pow(x*x, n/2) : my_pow(x, n-1)*x
end
