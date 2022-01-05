function fizzBuzz(n: number): string[] {
    const answers: string[] = []
    for (let x = 1; x <= n; x++) {
        const answer = (x % 15 == 0) ? "FizzBuzz" :
                       (x %  3 == 0) ? "Fizz"     :
                       (x %  5 == 0) ? "Buzz"     : x.toString()
        answers.push(answer)
    }
    return answers
};

console.log(fizzBuzz(3)) // ["1","2","Fizz"]
console.log(fizzBuzz(5)) // ["1","2","Fizz","4","Buzz"]
console.log(fizzBuzz(15)) // ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]