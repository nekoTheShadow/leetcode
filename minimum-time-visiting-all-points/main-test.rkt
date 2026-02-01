#lang racket

(require rackunit
         "./main.rkt")

(check-equal? (min-time-to-visit-all-points '((1 1) (3 4) (-1 0))) 7)
(check-equal? (min-time-to-visit-all-points '((3 2) (-2 2))) 5)