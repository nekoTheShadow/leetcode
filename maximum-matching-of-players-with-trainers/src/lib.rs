impl Solution {
    pub fn match_players_and_trainers(players: Vec<i32>, trainers: Vec<i32>) -> i32 {
        let mut players = players;
        let mut trainers = trainers;
        players.sort();
        trainers.sort();

        let mut x = 0;
        let mut y = 0;
        let mut count = 0;
        while x < players.len() && y < trainers.len() {
            if players[x] <= trainers[y] {
                x += 1;
                y += 1;
                count += 1;
            } else {
                y += 1;
            }
        }
        count
    }
}

struct Solution;

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn example1() {
        let players = [4, 7, 9];
        let trainers = [8, 2, 5, 8];
        let output = 2;
        assert_eq!(
            Solution::match_players_and_trainers(players.to_vec(), trainers.to_vec()),
            output
        );
    }

    #[test]
    fn example2() {
        let players = [1, 1, 1];
        let trainers = [10];
        let output = 1;
        assert_eq!(
            Solution::match_players_and_trainers(players.to_vec(), trainers.to_vec()),
            output
        );
    }
}
