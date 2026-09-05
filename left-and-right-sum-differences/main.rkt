#lang racket

(define (left-right-difference nums)
  (define l-sum 0)
  (define r-sum (for/sum ([v nums]) v))

  (for/list ([v nums])
    (define total (abs (- l-sum (- r-sum v))))
    (set! l-sum (+ l-sum v))
    (set! r-sum (- r-sum v))
    total))

(module+ test
  (require rackunit
           json)
  (check-equal? (left-right-difference (string->jsexpr "[10,4,8,3]")) (string->jsexpr "[15,1,11,22]"))
  (check-equal? (left-right-difference (string->jsexpr "[1]")) (string->jsexpr "[0]")))
