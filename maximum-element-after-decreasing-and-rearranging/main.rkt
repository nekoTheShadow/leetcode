#lang racket

(define (maximum-element-after-decrementing-and-rearranging arr)
  (define vec (list->vector arr))
  (vector-sort! vec <)

  (define n (vector-length vec))
  (vector-set! vec 0 1)
  (for ([i (in-range 1 n)])
    (vector-set! vec i (min (vector-ref vec i) (+ (vector-ref vec (- i 1)) 1))))
  (vector-ref vec (- n 1)))

(module+ test
  (require rackunit
           json)
  (check-equal? (maximum-element-after-decrementing-and-rearranging (string->jsexpr "[2,2,1,2,1]")) 2)
  (check-equal? (maximum-element-after-decrementing-and-rearranging (string->jsexpr "[100,1,1000]"))
                3)
  (check-equal? (maximum-element-after-decrementing-and-rearranging (string->jsexpr "[1,2,3,4,5]"))
                5))
