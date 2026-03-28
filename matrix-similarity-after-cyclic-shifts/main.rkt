#lang racket

(define (are-similar mat k)
  (for/and ([(lst i) (in-indexed mat)])
    (or [and (even? i) (equal? lst (l-rotate lst k))] [and (odd? i) (equal? lst (r-rotate lst k))])))

(define (l-rotate lst n)
  (define m (modulo n (length lst)))
  (append (drop lst m) (take lst m)))

(define (r-rotate lst n)
  (define len (length lst))
  (define m (- len (modulo n len)))
  (append (drop lst m) (take lst m)))

(module+ main
  (require json)
  (define mat (string->jsexpr "[[1,2,3],[4,5,6],[7,8,9]]"))
  (define k 4)
  (are-similar mat k))

(module+ test
  (require json
           rackunit)
  (test-case "example1"
    (define mat (string->jsexpr "[[1,2,3],[4,5,6],[7,8,9]]"))
    (define k 4)
    (check-false (are-similar mat k)))
  (test-case "example2"
    (define mat (string->jsexpr "[[1,2,1,2],[5,5,5,5],[6,3,6,3]]"))
    (define k 2)
    (check-true (are-similar mat k)))
  (test-case "example3"
    (define mat (string->jsexpr "[[2,2],[2,2]]"))
    (define k 3)
    (check-true (are-similar mat k))))
