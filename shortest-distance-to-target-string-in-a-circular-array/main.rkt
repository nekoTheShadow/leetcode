#lang racket

(define (closest-target words target startIndex)
  (define n (length words))
  (define ret 100000)

  (for ([(word i) (in-indexed words)])
    (when (equal? word target)
      (define len1 (abs (- startIndex i)))
      (define len2 (- n len1))
      (set! ret (min ret len1 len2))))

  (if (= ret 100000) -1 ret))

(module+ test
  (require rackunit
           json)
  (test-case "Example 1"
    (define words '("hello" "i" "am" "leetcode" "hello"))
    (define target "hello")
    (define startIndex 1)
    (define output 1)
    (check-eq? (closest-target words target startIndex) output))
  (test-case "Example 2"
    (define words '("a" "b" "leetcode"))
    (define target "leetcode")
    (define startIndex 0)
    (define output 1)
    (check-eq? (closest-target words target startIndex) output))
  (test-case "Example 3"
    (define words '("i" "eat" "leetcode"))
    (define target "ate")
    (define startIndex 0)
    (define output -1)
    (check-eq? (closest-target words target startIndex) output)))
