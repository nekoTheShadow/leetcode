# @param {Integer} n
# @param {Integer} k
# @return {Integer}
def kth_grammar(n, k)
    return f(n, k-1)
end

def f(n, k)
    return 0 if n==1

    if f(n-1, k/2)==0
        k%2==0 ? 0 : 1
    else
        k%2==0 ? 1 : 0
    end
end
