#lang racket

(define (can-partition-grid grid)
  (let/cc return
    (define tot (sum (flatten grid)))

    (define s1 0)
    (for ([row grid])
      (set! s1 (+ s1 (sum row)))
      (when (= s1 (- tot s1))
        (return #t)))

    (define s2 0)
    (for ([row (apply map list grid)])
      (set! s2 (+ s2 (sum row)))
      (when (= s2 (- tot s2))
        (return #t)))

    (return #f)))

(define (sum lst)
  (for/sum ([v lst]) v))

(module+ test
  (require rackunit
           json)
  (check-true (can-partition-grid (string->jsexpr "[[1,4],[2,3]]")))
  (check-false (can-partition-grid (string->jsexpr "[[1,3],[2,4]]"))))
