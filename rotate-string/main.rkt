#lang racket

(define (rotate-string s goal)
  (define n (string-length s))
  (define m (string-length goal))
  (and (= n m)
       (for/or ([start (in-range n)])
         (for/and ([i (in-range n)])
           (define c1 (string-ref s (modulo (+ start i) n)))
           (define c2 (string-ref goal i))
           (equal? c1 c2)))))

(module+ test
  (require rackunit)
  (test-case "Example 1"
    (define s "abcde")
    (define goal "cdeab")
    (check-true (rotate-string s goal)))
  (test-case "Example 2"
    (define s "abcde")
    (define goal "abced")
    (check-false (rotate-string s goal))))
