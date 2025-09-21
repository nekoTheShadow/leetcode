use std::collections::{BTreeSet, HashMap};

struct MovieRentingSystem {
    // key: movie, value: [(price, shop)] (soreted by price)
    unrented: HashMap<i32, BTreeSet<(i32, i32)>>,

    // key: (shop, movie), value: price
    prices: HashMap<(i32, i32), i32>,

    // [(price, shop, movie)]
    rented: BTreeSet<(i32, i32, i32)>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MovieRentingSystem {
    fn new(n: i32, entries: Vec<Vec<i32>>) -> Self {
        let mut unrented = HashMap::new();
        let mut prices = HashMap::new();
        for entry in entries {
            let shop = entry[0];
            let movie = entry[1];
            let price = entry[2];

            unrented
                .entry(movie)
                .or_insert(BTreeSet::new())
                .insert((price, shop));
            prices.insert((shop, movie), price);
        }
        Self {
            unrented: unrented,
            prices: prices,
            rented: BTreeSet::new(),
        }
    }

    fn search(&self, movie: i32) -> Vec<i32> {
        if let Some(ps) = self.unrented.get(&movie) {
            ps.iter().take(5).map(|(_price, shop)| *shop).collect()
        } else {
            vec![]
        }
    }

    fn rent(&mut self, shop: i32, movie: i32) {
        let price = self.prices[&(shop, movie)];
        self.unrented
            .get_mut(&movie)
            .unwrap()
            .remove(&(price, shop));
        self.rented.insert((price, shop, movie));
    }

    fn drop(&mut self, shop: i32, movie: i32) {
        let price = self.prices[&(shop, movie)];
        self.unrented.get_mut(&movie).unwrap().insert((price, shop));
        self.rented.remove(&(price, shop, movie));
    }

    fn report(&self) -> Vec<Vec<i32>> {
        self.rented
            .iter()
            .take(5)
            .map(|(price, shop, movie)| vec![*shop, *movie])
            .collect()
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * let obj = MovieRentingSystem::new(n, entries);
 * let ret_1: Vec<i32> = obj.search(movie);
 * obj.rent(shop, movie);
 * obj.drop(shop, movie);
 * let ret_4: Vec<Vec<i32>> = obj.report();
 */

fn main() {
    println!("Hello, world!");
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let mut sys = MovieRentingSystem::new(
            3,
            vec![
                vec![0, 1, 5],
                vec![0, 2, 6],
                vec![0, 3, 7],
                vec![1, 1, 4],
                vec![1, 2, 7],
                vec![2, 1, 5],
            ],
        );

        // search(1) -> [1, 0, 2]
        assert_eq!(sys.search(1), vec![1, 0, 2]);

        // rent(0, 1)
        sys.rent(0, 1);

        // rent(1, 2)
        sys.rent(1, 2);

        // report() -> [[0, 1], [1, 2]]
        assert_eq!(sys.report(), vec![vec![0, 1], vec![1, 2]]);

        // drop(1, 2)
        sys.drop(1, 2);

        // search(2) -> [0, 1]
        assert_eq!(sys.search(2), vec![0, 1]);
    }

    #[test]
    fn ng1() {
        let mut sys = MovieRentingSystem::new(
            10,
            vec![
                vec![0, 418, 3],
                vec![9, 5144, 46],
                vec![2, 8986, 29],
                vec![6, 1446, 28],
                vec![3, 8215, 97],
                vec![7, 9105, 34],
                vec![6, 9105, 30],
                vec![5, 1722, 94],
                vec![9, 528, 40],
                vec![3, 850, 77],
                vec![3, 7069, 40],
                vec![8, 1997, 42],
                vec![0, 8215, 28],
                vec![7, 4050, 80],
                vec![4, 7100, 97],
                vec![4, 9686, 32],
                vec![4, 2566, 93],
                vec![2, 8320, 12],
                vec![2, 5495, 56],
            ],
        );

        // search(7837) -> []
        assert_eq!(sys.search(7837), vec![]);

        // search(5495) -> [2]
        assert_eq!(sys.search(5495), vec![2]);

        // rent(4, 7100)
        sys.rent(4, 7100);

        // search(9105) -> [6, 7]
        assert_eq!(sys.search(9105), vec![6, 7]);

        // search(1446) -> [6]
        assert_eq!(sys.search(1446), vec![6]);

        // report() -> [[4, 7100]]
        assert_eq!(sys.report(), vec![vec![4, 7100]]);

        // search(9869) -> []
        assert_eq!(sys.search(9869), vec![]);

        // drop(4, 7100)
        sys.drop(4, 7100);

        // 再度 search(7100) -> [4]
        assert_eq!(sys.search(7100), vec![4]);
    }
}
