#lang racket

(define (xor-after-queries nums queries)
  (define MOD (+ (expt 10 9) 7))
  (define vec (list->vector nums))

  (for ([query queries])
    (define l (list-ref query 0))
    (define r (list-ref query 1))
    (define k (list-ref query 2))
    (define v (list-ref query 3))

    (for ([i (in-range l (+ r 1) k)])
      (vector-set! vec i (remainder (* (vector-ref vec i) v) MOD))))

  (for/fold ([acc 0]) ([v vec])
    (bitwise-xor acc v)))

(module+ test
  (require rackunit
           json)
  (test-case "Example 1"
    (define nums (string->jsexpr "[1,1,1]"))
    (define queries (string->jsexpr "[[0,2,1,4]]"))
    (define output 4)
    (check-eq? (xor-after-queries nums queries) output))
  (test-case "Example 1"
    (define nums (string->jsexpr "[2,3,1,5,4]"))
    (define queries (string->jsexpr "[[1,4,2,3],[0,2,1,2]]"))
    (define output 31)
    (check-eq? (xor-after-queries nums queries) output)))
