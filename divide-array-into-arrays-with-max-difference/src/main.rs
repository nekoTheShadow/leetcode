fn main() {
    println!("{:?}", Solution::divide_array(vec![1,3,4,8,7,9,3,5,1], 2));
    println!("{:?}", Solution::divide_array(vec![1,3,3,2,7,3], 3));
    println!("{:?}", Solution::divide_array(vec![6,10,5,12,7,11,6,6,12,12,11,7], 2));
    println!("{:?}", Solution::divide_array(vec![15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2], 2));
}


impl Solution {
    pub fn divide_array(nums: Vec<i32>, k: i32) -> Vec<Vec<i32>> {
        let mut nums = nums;
        nums.sort();

        let mut ret = vec![];
        for a in nums.chunks(3) {
            if a[2]-a[0]<=k {
                ret.push(a.to_vec());
            } else {
                return vec![];
            }
        }

        ret
    }
}

struct Solution{}
