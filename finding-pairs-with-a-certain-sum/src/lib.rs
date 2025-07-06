use std::collections::HashMap;

struct FindSumPairs {
    nums1: Vec<i32>,
    nums2: Vec<i32>,
    dict2: HashMap<i32, i32>,
}

impl FindSumPairs {
    fn new(nums1: Vec<i32>, nums2: Vec<i32>) -> Self {
        let mut dict2 = HashMap::new();
        for &num2 in &nums2 {
            *dict2.entry(num2).or_insert(0) += 1;
        }
        Self {
            nums1,
            nums2,
            dict2,
        }
    }

    fn add(&mut self, index: i32, val: i32) {
        let index = index as usize;

        *self.dict2.get_mut(&self.nums2[index]).unwrap() -= 1;
        self.nums2[index] += val;
        *self.dict2.entry(self.nums2[index]).or_insert(0) += 1;
    }

    fn count(&self, tot: i32) -> i32 {
        self.nums1
            .iter()
            .filter_map(|&num1| self.dict2.get(&(tot - num1)))
            .sum()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let mut f = FindSumPairs::new(vec![1, 1, 2, 2, 2, 3], vec![1, 4, 5, 2, 5, 4]);
        assert_eq!(f.count(7), 8);
        f.add(3, 2);
        assert_eq!(f.count(8), 2);
        assert_eq!(f.count(4), 1);
        f.add(0, 1);
        f.add(1, 1);
        assert_eq!(f.count(7), 11);
    }
}
