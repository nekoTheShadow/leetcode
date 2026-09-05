#lang racket

(define (min-element nums)
  (define (sum-of-digits x)
    (if (< x 10)
        x
        (+ (modulo x 10) (sum-of-digits (quotient x 10)))))
  (apply min (map sum-of-digits nums)))

(module+ test
  (require json
           rackunit)
  (check-equal? (min-element (string->jsexpr "[10,12,13,14]")) 1)
  (check-equal? (min-element (string->jsexpr "[1,2,3,4]")) 1)
  (check-equal? (min-element (string->jsexpr "[999,19,199]")) 10))
