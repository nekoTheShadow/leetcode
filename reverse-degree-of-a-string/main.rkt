#lang racket

(define (reverse-degree s)
  (for/sum ([(ch i) (in-indexed s)])
           (define index-in-reversed-alphabet (- 26 (- (char->integer ch) (char->integer #\a))))
           (* index-in-reversed-alphabet (+ i 1))))

(module+ test
  (require rackunit)
  (test-case "Example 1"
    (check-eq? (reverse-degree "abc") 148))
  (test-case "Example 2"
    (check-eq? (reverse-degree "zaza") 160)))
