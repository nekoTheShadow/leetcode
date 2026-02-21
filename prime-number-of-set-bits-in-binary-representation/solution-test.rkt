#lang racket

(require "./solution.rkt"
         rackunit)

(check-equal? (count-prime-set-bits 6 10) 4)
(check-equal? (count-prime-set-bits 10 15) 5)
