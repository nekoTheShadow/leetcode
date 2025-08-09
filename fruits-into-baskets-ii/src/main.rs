impl Solution {
    pub fn num_of_unplaced_fruits(fruits: Vec<i32>, mut baskets: Vec<i32>) -> i32 {
        for fruit in fruits {
            baskets
                .iter_mut()
                .find(|&&mut basket| basket >= fruit)
                .map(|basket| *basket = -1);
        }
        baskets.iter().filter(|&&basket| basket != -1).count() as i32
    }
}

struct Solution;

fn main() {
    let fruits = [4, 2, 5];
    let baskets = [3, 5, 4];
    let output = 1;
    assert_eq!(
        Solution::num_of_unplaced_fruits(fruits.to_vec(), baskets.to_vec()),
        output
    );

    let fruits = [3, 6, 1];
    let baskets = [6, 4, 7];
    let output = 0;
    assert_eq!(
        Solution::num_of_unplaced_fruits(fruits.to_vec(), baskets.to_vec()),
        output
    );
}
