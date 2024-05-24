impl Solution {
    pub fn max_score_words(words: Vec<String>, letters: Vec<char>, score: Vec<i32>) -> i32 {
        let mut count = vec![0; 26];
        for ch in letters {
            count[Self::ord(ch)] += 1;
        }

        let scores = words.iter().map(|word| {
            word.chars().map(|ch| score[Self::ord(ch)]).sum()
        }).collect::<Vec<i32>>();

        let mut max_score = 0;
        Self::backtrack(&words, &scores, 0, &mut count, &mut 0, &mut max_score);
        max_score
    }

    pub fn backtrack(words: &[String], scores: &[i32], cur: usize, count: &mut [i32], cur_score: &mut i32, max_score: &mut i32) {
        if words.len() == cur {
            *max_score = std::cmp::max(*max_score, *cur_score);
            return 
        }

        Self::backtrack(words, scores, cur+1, count, cur_score, max_score); // words[cur]を採用しない

        for ch in words[cur].chars() {
            count[Self::ord(ch)] -= 1;
        }

        if count.iter().all(|v| *v >= 0) {
            *cur_score += scores[cur];
            Self::backtrack(words, scores, cur+1, count, cur_score, max_score);
            *cur_score -= scores[cur];
        }

        for ch in words[cur].chars() {
            count[Self::ord(ch)] += 1;
        } 
    }

    pub fn ord(ch: char) -> usize {
        return ch as usize - 'a' as usize;
    }
}
struct Solution;

fn main() {
    example1();
    example2();
    example3();
}

fn example1() {
    let words = ["dog","cat","dad","good"].map(|s| s.to_string()).to_vec(); 
    let letters = ["a","a","c","d","d","d","g","o","o"].map(|s| s.chars().next().unwrap()).to_vec();
    let score = [1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0].to_vec();
    println!("{}", Solution::max_score_words(words, letters, score));
}

fn example2() {
    let words = ["xxxz","ax","bx","cx"].map(|s| s.to_string()).to_vec(); 
    let letters = ["z","a","b","c","x","x","x"].map(|s| s.chars().next().unwrap()).to_vec();
    let score = [4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10].to_vec();
    println!("{}", Solution::max_score_words(words, letters, score));
}

fn example3() {
    let words = ["leetcode"].map(|s| s.to_string()).to_vec(); 
    let letters = ["l","e","t","c","o","d"].map(|s| s.chars().next().unwrap()).to_vec();
    let score = [0,0,1,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0].to_vec();
    println!("{}", Solution::max_score_words(words, letters, score));
}