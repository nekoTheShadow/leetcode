
# @param {String[]} codes
# @param {String[]} business_lines
# @param {Boolean[]} is_actives
# @return {String[]}
def validate_coupons(codes, business_lines, is_actives)
    valid_bussiness_lines = ["electronics", "grocery", "pharmacy", "restaurant"];
    codes.zip(business_lines, is_actives) 
        .filter{|code, business_line, is_active| code =~ /^[A-Za-z0-9_]+$/ && valid_bussiness_lines.include?(business_line) && is_active} 
        .sort_by{|code, business_line, is_active| [valid_bussiness_lines.index(business_line), code]}
        .map{|code, business_line, is_active| code}
end


require "minitest/autorun"

describe "3606. Coupon Code Validator" do
    it "example1" do
        code = ["SAVE20","","PHARMA5","SAVE@20"]
        business_line = ["restaurant","grocery","pharmacy","restaurant"]
        is_active = [true,true,true,true]
        output = ["PHARMA5","SAVE20"]
        _(validate_coupons(code, business_line, is_active)).must_equal output
    end

    it "example2" do
        code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"]
        business_line = ["grocery","electronics","invalid"]
        is_active = [false,true,true]
        output = ["ELECTRONICS_50"]
        _(validate_coupons(code, business_line, is_active)).must_equal output
    end
end
