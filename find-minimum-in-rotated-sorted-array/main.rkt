#lang racket

(define (find-min nums)
  (define vec (list->vector nums))
  (define n (vector-length vec))
  (let loop ([ok n]
             [ng -1])
    (if (> (abs (- ok ng)) 1)
        (let ([mi (quotient (+ ok ng) 2)])
          (if (<= (vector-ref vec mi) (vector-ref vec (- n 1)))
              (loop mi ng)
              (loop ok mi)))
        (vector-ref vec ok))))

(module+ test
  (require rackunit
           json)
  (test-case "Example 1"
    (define nums "[3,4,5,1,2]")
    (define output 1)
    (check-equal? (find-min (string->jsexpr nums)) output))

  (test-case "Example 2"
    (define nums "[4,5,6,7,0,1,2]")
    (define output 0)
    (check-equal? (find-min (string->jsexpr nums)) output))

  (test-case "Example 3"
    (define nums "[11,13,15,17]")
    (define output 11)
    (check-equal? (find-min (string->jsexpr nums)) output)))
