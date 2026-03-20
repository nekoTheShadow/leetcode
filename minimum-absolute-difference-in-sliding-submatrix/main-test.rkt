#lang racket

(require "./main.rkt" rackunit)

(check-equal? (min-abs-diff '((1 8) (3 -2)) 2) '((2)))
(check-equal? (min-abs-diff '((3 -1)) 1) '((0 0)))
(check-equal? (min-abs-diff '((1 -2 3) (2 3 5)) 2) '((1 2)))