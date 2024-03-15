impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let n = nums.len();
        let mut a = vec![1; n];
        let mut b = vec![1; n];
        for i in 0..n-1 {
            a[i+1] = a[i] * nums[i];
        }
        for i in (1..n).rev() {
            b[i-1] = b[i] * nums[i];
        }
    
        (0..n).map(|i| a[i]*b[i]).collect::<Vec<_>>()
    }
}

fn main() {
    println!("{:?}", Solution::product_except_self(vec![1,2,3,4]));
    println!("{:?}", Solution::product_except_self(vec![-1,1,0,-3,3]));
}


struct Solution{}

