impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<Vec<i32>>) -> String {
        let n = s.len();
        let mut imos = vec![0; n + 1];
        for shift in shifts {
            let l = shift[0] as usize;
            let r = shift[1] as usize;
            let d = shift[2];

            if d == 1 {
                imos[l] += 1;
                imos[r + 1] -= 1;
            } else {
                imos[l] -= 1;
                imos[r + 1] += 1;
            }
        }

        for i in 0..n {
            imos[i + 1] += imos[i]
        }

        let mut t = String::new();
        for (i, ch) in s.chars().enumerate() {
            let x = ((imos[i] % 26) + 26) % 26;
            let new_char = ((ch as i32) - ('a' as i32) + x) % 26 + ('a' as i32);
            t.push(std::char::from_u32(new_char as u32).unwrap());
        }
        t
    }
}

struct Solution;

fn main() {
    println!(
        "{}",
        Solution::shifting_letters(
            "abc".to_string(),
            [[0, 1, 0], [1, 2, 1], [0, 2, 1]]
                .map(|s| s.to_vec())
                .to_vec()
        )
    );
    println!(
        "{}",
        Solution::shifting_letters(
            "dztz".to_string(),
            [[0, 0, 0], [1, 1, 1]].map(|s| s.to_vec()).to_vec()
        )
    );
}
