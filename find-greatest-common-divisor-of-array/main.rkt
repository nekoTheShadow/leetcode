#lang racket

(define (find-gcd nums)
  (gcd (apply max nums) (apply min nums)))

(module+ test
  (require rackunit
           json)
  (check-equal? (find-gcd (string->jsexpr "[2,5,6,9,10]")) 2)
  (check-equal? (find-gcd (string->jsexpr "[7,5,6,8,3]")) 1)
  (check-equal? (find-gcd (string->jsexpr "[3,3]")) 3))
