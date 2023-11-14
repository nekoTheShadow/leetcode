# @param {String} s
# @return {Integer}
def count_palindromic_subsequence(s)
    a = Hash.new{|h, k| h[k] = []}
    s.chars.each_with_index{|ch, i| a[ch] << i}
    
    ans = 0
    [*'a'..'z'].product([*'a'..'z']).each do |ch1, ch2|
        next if a[ch1].size<2
        if ch1==ch2
            ans+=1 if a[ch1].size>=3
        else
            mi = a[ch1].first
            ma = a[ch1].last 
            ans+=1 if a[ch2].find{|x| mi<=x && x<=ma} 
        end
    end
    ans
end
