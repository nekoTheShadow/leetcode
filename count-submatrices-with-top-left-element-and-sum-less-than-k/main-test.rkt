#lang racket

(require "./main.rkt"
         rackunit)

(check-equal? (count-submatrices '((7 6 3) (6 6 1)) 18) 4)
(check-equal? (count-submatrices '((7 2 9) (1 5 0) (2 6 6)) 20) 6)
