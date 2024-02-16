use std::collections::HashMap;



impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        let mut map = HashMap::new();
        for num in arr {
            map.entry(num).and_modify(|val| *val+=1).or_insert(1);
        }

        let mut vals = map.into_values().collect::<Vec<_>>();
        vals.sort_unstable();

        let mut k = k;
        let mut r = vals.len();
        for val in vals {
            if k < val {
                break;
            }
            k -= val;
            r -= 1;
        }
        r as i32
    }
}

fn main() {
    println!("{}", Solution::find_least_num_of_unique_ints(vec![5,5,4], 1));
    println!("{}", Solution::find_least_num_of_unique_ints(vec![4,3,1,1,3,3,2], 3));
}

struct Solution{}