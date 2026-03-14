#lang racket

(require rackunit
         "./solution.rkt")

(check-equal? (bitwise-complement 5) 2)
(check-equal? (bitwise-complement 7) 0)
(check-equal? (bitwise-complement 10) 5)
