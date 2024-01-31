impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        let n = temperatures.len();
        let mut ans = vec![0i32; n];
        let mut stack = vec![];

        for i in 0..n {
            while !stack.is_empty() && temperatures[stack[stack.len()-1]] < temperatures[i] {
                let j = stack.pop().unwrap();
                ans[j] = (i-j) as i32;
            }
            stack.push(i); 
        }

        ans
    }
}

struct Solution {}

#[test]
fn example1() {
    assert_eq!(Solution::daily_temperatures(vec![73,74,75,71,69,72,76,73]), vec![1,1,4,2,1,1,0,0]);
}

#[test]
fn example2() {
    assert_eq!(Solution::daily_temperatures(vec![30,40,50,60]), vec![1,1,1,0]);
}

#[test]
fn example3() {
    assert_eq!(Solution::daily_temperatures(vec![30,60,90]), vec![1,1,0]);
}

fn main() {
    Solution::daily_temperatures(vec![73,74,75,71,69,72,76,73]);
}
