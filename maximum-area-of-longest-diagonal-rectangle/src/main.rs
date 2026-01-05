impl Solution {
    pub fn area_of_max_diagonal(dimensions: Vec<Vec<i32>>) -> i32 {
        let (_max_diagonal, max_area) = dimensions
            .iter()
            .map(|d| (d[0] * d[0] + d[1] * d[1], d[0] * d[1]))
            .max()
            .unwrap();
        max_area
    }
}

struct Solution;

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod test {
    use crate::Solution;

    #[test]
    fn example1() {
        let dimensions = [[9, 3], [8, 6]];
        let output = 48;
        assert_eq!(
            Solution::area_of_max_diagonal(dimensions.map(|dimension| dimension.to_vec()).to_vec()),
            output
        )
    }

    #[test]
    fn example2() {
        let dimensions = [[3, 4], [4, 3]];
        let output = 12;
        assert_eq!(
            Solution::area_of_max_diagonal(dimensions.map(|dimension| dimension.to_vec()).to_vec()),
            output
        )
    }
}
