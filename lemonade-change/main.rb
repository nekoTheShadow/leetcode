# @param {Integer[]} bills
# @return {Boolean}
def lemonade_change(bills)
    bill05 = 0
    bill10 = 0
    bill20 = 0
    
    bills.each do |bill|
        if bill == 5 
            bill05 += 1
        end
        
        if bill == 10
            return false if bill05 == 0
            bill05 -= 1
            bill10 += 1
        end

        if bill == 20
            if bill05 > 0 && bill10 > 0
                bill05 -= 1
                bill10 -= 1
                bill20 += 1
            elsif bill05 >= 3
                bill05 -= 3
                bill20 += 1
            else
                return false
            end
        end
    end

    true
end
