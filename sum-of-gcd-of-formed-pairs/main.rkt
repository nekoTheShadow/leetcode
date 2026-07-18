#lang racket

(define (gcd-sum nums)
  (define vec (list->vector nums))
  (define n (vector-length vec))

  (define mx 0)
  (define prefix-gcd (make-vector n))
  (for ([i (in-range n)])
    (define v (vector-ref vec i))
    (set! mx (max mx v))
    (vector-set! prefix-gcd i (gcd mx v)))

  (vector-sort! prefix-gcd <)
  (for/sum ([i (in-range (quotient n 2))])
           (define v1 (vector-ref prefix-gcd i))
           (define v2 (vector-ref prefix-gcd (- n i 1)))
           (gcd v1 v2)))

(module+ test
  (require json
           rackunit)
  (check-equal? (gcd-sum (string->jsexpr "[2,6,4]")) 2)
  (check-equal? (gcd-sum (string->jsexpr "[3,6,2,8]")) 5))
