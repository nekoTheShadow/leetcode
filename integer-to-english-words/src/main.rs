impl Solution {
    const LESS20: [&'static str; 20] = [
        "",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen",
    ];
    const TENS: [&'static str; 10] = [
        "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
    ];
    const THOUSANDS: [&'static str; 4] = ["", "Thousand", "Million", "Billion"];

    pub fn number_to_words(num: i32) -> String {
        if num == 0 {
            return "Zero".to_string();
        }

        let mut num = num as usize;
        let mut i = 0;
        let mut ret = vec![];
        while num > 0 {
            if num % 1000 > 0 {
                let mut a = Self::helper(num % 1000);
                if i > 0 {
                    a.push(Self::THOUSANDS[i].to_string());
                }
                ret.push(a.join(" "));
            }

            num /= 1000;
            i += 1;
        }

        ret.reverse();
        ret.join(" ")
    }

    pub fn helper(num: usize) -> Vec<String> {
        if num == 0 {
            vec![]
        } else if num < 20 {
            vec![Self::LESS20[num].to_string()]
        } else if num < 100 {
            let mut a = vec![Self::TENS[num / 10].to_string()];
            a.extend(Self::helper(num % 10));
            a
        } else {
            let mut a = vec![Self::LESS20[num / 100].to_string(), "Hundred".to_string()];
            a.extend(Self::helper(num % 100));
            a
        }
    }
}

struct Solution;

fn main() {
    println!("{}", Solution::number_to_words(123));
    println!("{}", Solution::number_to_words(12345));
    println!("{}", Solution::number_to_words(1234567));
}
