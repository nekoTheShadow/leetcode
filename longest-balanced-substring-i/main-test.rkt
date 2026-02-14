#lang racket

(require rackunit
         "./main.rkt")

(check-equal? (longest-balanced "abbac") 4)
(check-equal? (longest-balanced "zzabccy") 4)
(check-equal? (longest-balanced "aba") 2)
