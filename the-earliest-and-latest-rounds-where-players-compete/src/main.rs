use std::collections::HashMap;

impl Solution {
    pub fn earliest_and_latest(n: i32, first_player: i32, second_player: i32) -> Vec<i32> {
        let mut memo = HashMap::new();
        let mut max = 0;
        let mut min = 100000;
        dfs(
            first_player - 1,
            second_player - 1,
            &(0..n).into_iter().collect::<Vec<_>>(),
            1,
            &mut memo,
            &mut max,
            &mut min,
        );
        vec![min, max]
    }
}

fn dfs(
    first_player: i32,
    second_player: i32,
    players: &[i32],
    round: i32,
    memo: &mut HashMap<i32, i32>,
    max: &mut i32,
    min: &mut i32,
) {
    let key = to_bit(players);
    if memo.contains_key(&key) {
        return;
    }
    memo.insert(key, round);

    let m = players.len();
    let pairs = (0..m / 2)
        .map(|i| (players[i], players[m - i - 1]))
        .collect::<Vec<_>>();

    if pairs.contains(&(first_player, second_player)) {
        *max = std::cmp::max(*max, round);
        *min = std::cmp::min(*min, round);
        return;
    }

    for new_players in helper(first_player, second_player, &pairs) {
        if m % 2 == 0 {
            dfs(
                first_player,
                second_player,
                &new_players,
                round + 1,
                memo,
                max,
                min,
            );
        } else {
            dfs(
                first_player,
                second_player,
                &create_new_arr(&new_players, players[m / 2]),
                round + 1,
                memo,
                max,
                min,
            );
        }
    }
}

fn helper(first_player: i32, second_player: i32, pairs: &[(i32, i32)]) -> Vec<Vec<i32>> {
    let (player1, player2) = pairs[0];

    let mut winners = Vec::new();
    if player1 == first_player || player1 == second_player {
        winners.push(player1);
    } else if player2 == first_player || player2 == second_player {
        winners.push(player2);
    } else {
        winners.push(player1);
        winners.push(player2);
    }

    if pairs.len() == 1 {
        winners.iter().map(|winner| vec![*winner]).collect()
    } else {
        let mut ret = Vec::new();
        for winner in winners {
            for arr in helper(first_player, second_player, &pairs[1..]) {
                ret.push(create_new_arr(&arr, winner));
            }
        }
        ret
    }
}

fn create_new_arr(arr: &Vec<i32>, new_val: i32) -> Vec<i32> {
    let mut new_arr = vec![new_val];
    new_arr.extend(arr.iter());
    new_arr.sort();
    new_arr
}

fn to_bit(players: &[i32]) -> i32 {
    let mut bit = 0;
    for player in players {
        bit |= 1 << player
    }
    bit
}

pub struct Solution;

fn main() {
    let n = 11;
    let first_player = 2;
    let second_player = 4;
    let output = [3, 4];
    assert_eq!(
        Solution::earliest_and_latest(n, first_player, second_player),
        output.to_vec()
    );
}
