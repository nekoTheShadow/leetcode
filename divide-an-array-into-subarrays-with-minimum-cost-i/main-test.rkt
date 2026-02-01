#lang racket

(require rackunit
         "./main.rkt")

(check-equal? (minimum-cost '(1 2 3 12)) 6 "Example 1")
(check-equal? (minimum-cost '(5 4 3)) 12 "Example 2")
(check-equal? (minimum-cost '(10 3 1 1)) 12 "Example 3")
