#lang racket

(define (max-number-of-balloons text)
  (define ht (make-hash))
  (for ([ch text])
    (hash-update! ht ch add1 0))

  (define b (hash-ref ht #\b 0))
  (define a (hash-ref ht #\a 0))
  (define l (hash-ref ht #\l 0)) ; div 2
  (define o (hash-ref ht #\o 0)) ; div 2
  (define n (hash-ref ht #\n 0))
  (min b a (quotient l 2) (quotient o 2) n))

(module+ test
  (require rackunit)
  (check-equal? (max-number-of-balloons "nlaebolko") 1)
  (check-equal? (max-number-of-balloons "loonbalxballpoon") 2)
  (check-equal? (max-number-of-balloons "leetcode") 0))
