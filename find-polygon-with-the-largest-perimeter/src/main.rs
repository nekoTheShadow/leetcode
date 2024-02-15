fn main() {
    println!("{}", Solution::largest_perimeter(vec![5,5,5]));
    println!("{}", Solution::largest_perimeter(vec![1,12,1,2,5,50,3]));
    println!("{}", Solution::largest_perimeter(vec![5,5,50]));
}

impl Solution {
    pub fn largest_perimeter(nums: Vec<i32>) -> i64 {
        let mut nums = nums.into_iter().map(|num| num as i64).collect::<Vec<_>>();
        nums.sort();
        nums.reverse();

        let mut tot = nums.iter().sum::<i64>();
        let mut c = nums.len();
        for num in nums {
            if num < tot-num {
                break;
            }
            c -= 1;
            tot -= num;
        }

        if c>2 {
            tot
        } else {
            -1
        }
    }
}

struct Solution{}