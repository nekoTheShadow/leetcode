use std::{
    cmp::Reverse,
    collections::{BTreeSet, HashMap},
};

use itertools::izip;

struct FoodRatings {
    // key: food, value: rating
    ratings: HashMap<String, i32>,

    // key: food, value: cuisine
    cuisines: HashMap<String, String>,

    // key: cuisine, value: [(rating, food)]
    tuples: HashMap<String, BTreeSet<(i32, Reverse<String>)>>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl FoodRatings {
    fn new(foods: Vec<String>, cuisines: Vec<String>, ratings: Vec<i32>) -> Self {
        let mut d1 = HashMap::new();
        let mut d2 = HashMap::new();
        let mut tuples = HashMap::new();
        for (food, cuisine, rating) in izip!(foods, cuisines, ratings) {
            d1.insert(food.clone(), rating);
            d2.insert(food.clone(), cuisine.clone());
            tuples
                .entry(cuisine)
                .or_insert(BTreeSet::new())
                .insert((rating, Reverse(food)));
        }
        Self {
            ratings: d1,
            cuisines: d2,
            tuples: tuples,
        }
    }

    fn change_rating(&mut self, food: String, new_rating: i32) {
        let old_rating = *self.ratings.get(&food).unwrap();
        let cuisine = self.cuisines.get(&food).unwrap();

        self.ratings.insert(food.clone(), new_rating);
        self.tuples
            .get_mut(cuisine)
            .unwrap()
            .remove(&(old_rating, Reverse(food.clone())));
        self.tuples
            .get_mut(cuisine)
            .unwrap()
            .insert((new_rating, Reverse(food.clone())));
    }

    fn highest_rated(&self, cuisine: String) -> String {
        let (_rating, Reverse(food)) = self.tuples.get(&cuisine).unwrap().last().unwrap();
        food.clone()
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * let obj = FoodRatings::new(foods, cuisines, ratings);
 * obj.change_rating(food, newRating);
 * let ret_2: String = obj.highest_rated(cuisine);
 */

fn main() {
    let foods = ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"];
    let cuisines = [
        "korean", "japanese", "japanese", "greek", "japanese", "korean",
    ];
    let ratings = [9, 12, 8, 15, 14, 7];
    let mut food_ratings = FoodRatings::new(
        foods.map(|food| String::from(food)).to_vec(),
        cuisines.map(|cusine| String::from(cusine)).to_vec(),
        ratings.to_vec(),
    );

    assert_eq!(food_ratings.highest_rated("korean".into()), "kimchi");
    assert_eq!(food_ratings.highest_rated("japanese".into()), "ramen");
    food_ratings.change_rating("sushi".into(), 16);
    assert_eq!(food_ratings.highest_rated("japanese".into()), "sushi");
    food_ratings.change_rating("ramen".into(), 16);
    assert_eq!(food_ratings.highest_rated("japanese".into()), "ramen");
}
