use std::collections::{BTreeSet, HashMap};

struct NumberContainers {
    numbers: HashMap<i32, i32>,
    indexes: HashMap<i32, BTreeSet<i32>>,
}

impl NumberContainers {
    fn new() -> Self {
        Self {
            numbers: HashMap::new(),
            indexes: HashMap::new(),
        }
    }

    fn change(&mut self, index: i32, number: i32) {
        if let Some(&old_number) = self.numbers.get(&index) {
            self.numbers.remove(&index);
            self.indexes.get_mut(&old_number).unwrap().remove(&index);
            if self.indexes[&old_number].is_empty() {
                self.indexes.remove(&old_number);
            }
        }

        self.numbers.insert(index, number);
        self.indexes
            .entry(number)
            .or_insert(BTreeSet::new())
            .insert(index);
    }

    fn find(&self, number: i32) -> i32 {
        if let Some(tree_set) = self.indexes.get(&number) {
            *tree_set.first().unwrap()
        } else {
            -1
        }
    }
}

fn main() {
    let mut nc = NumberContainers::new();
    println!("{}", nc.find(10));
    nc.change(2, 10);
    nc.change(1, 10);
    nc.change(3, 10);
    nc.change(5, 10);
    println!("{}", nc.find(10));
    nc.change(1, 20);
    println!("{}", nc.find(10));
}
