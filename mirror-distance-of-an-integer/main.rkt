#lang racket

(define (mirror-distance n)
  (abs (- n (rev n))))

(define (rev x)
  (let loop ([tot 0]
             [n x])
    (if (= n 0)
        tot
        (loop (+ (* tot 10) (modulo n 10)) (quotient n 10)))))

(module+ test
  (require rackunit)
  (test-case "Example 1"
    (define n 25)
    (define output 27)
    (check-equal? (mirror-distance n) output))

  (test-case "Example 2"
    (define n 10)
    (define output 9)
    (check-equal? (mirror-distance n) output))

  (test-case "Example 3"
    (define n 7)
    (define output 0)
    (check-equal? (mirror-distance n) output)))
