#lang racket

(require "./solution.rkt"
         rackunit)

(check-equal? (binary-gap 22) 2)
(check-equal? (binary-gap 8) 0)
(check-equal? (binary-gap 5) 2)
