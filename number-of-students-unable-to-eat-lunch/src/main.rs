impl Solution {
    pub fn count_students(students: Vec<i32>, sandwiches: Vec<i32>) -> i32 {
        let n = students.len();
        let mut x = 0;
        let mut visited = vec![false; n];
        loop {
            let mut eat = false;
            for i in 0..n {
                if visited[i] {
                    continue;
                }
                if x < n && students[i] == sandwiches[x] {
                    visited[i] = true;
                    x += 1;
                    eat = true;
                }
            }
            if !eat {
                break
            }
        }

        visited.iter().filter(|&&v| !v).count() as i32
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::count_students(vec![1,1,0,0], vec![0,1,0,1]));
    println!("{}", Solution::count_students(vec![1,1,1,0,0,1], vec![1,0,0,0,1,1]));
}
