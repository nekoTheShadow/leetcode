impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        let n = 10_usize.pow(4);

        let mut c = vec![0_usize; n+1];
        for num in nums {
            c[num.abs() as usize] += 1;
        }

        let mut a = vec![];
        for i in 0..n+1 {
            for _ in 0..c[i] {
                a.push((i*i) as i32);
            }
        }
        a
    }
}

struct Solution{}

fn main() {
    println!("{:?}", Solution::sorted_squares(vec![-4,-1,0,3,10]));
    println!("{:?}", Solution::sorted_squares(vec![-7,-3,2,3,11]));
}
