# @param {String} customers
# @return {Integer}
def best_closing_time(customers)
    y=customers.count('Y')
    n=0
    
    x=0
    min=y+n
    customers.chars.each_with_index do |c, i|
        n+=1 if c=='N'
        y-=1 if c=='Y'
        if y+n<min
            x=i+1
            min=y+n
        end
    end
    x
end
