struct ProductOfNumbers {
    nums: Vec<i32>,
}

impl ProductOfNumbers {
    fn new() -> Self {
        Self { nums: Vec::new() }
    }

    fn add(&mut self, num: i32) {
        self.nums.push(num);
    }

    fn get_product(&self, k: i32) -> i32 {
        let n = self.nums.len();
        let k = k as usize;
        self.nums[(n - k)..].iter().product()
    }
}

fn main() {
    let mut product_of_numbers = ProductOfNumbers::new();
    product_of_numbers.add(3); // [3]
    product_of_numbers.add(0); // [3,0]
    product_of_numbers.add(2); // [3,0,2]
    product_of_numbers.add(5); // [3,0,2,5]
    product_of_numbers.add(4); // [3,0,2,5,4]
    println!("{}", product_of_numbers.get_product(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
    println!("{}", product_of_numbers.get_product(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    println!("{}", product_of_numbers.get_product(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
    product_of_numbers.add(8); // [3,0,2,5,4,8]
    println!("{}", product_of_numbers.get_product(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
}
