#lang racket

(define (maximum-jumps nums target)
  (main (list->vector nums) target))

(define (main nums target)
  (define n (vector-length nums))
  (define dp (make-vector n -1))
  (vector-set! dp 0 0)

  (for ([i (in-range n)])
    (define v1 (vector-ref nums i))
    (define c1 (vector-ref dp i))
    (unless (= c1 -1)
      (for ([j (in-range (+ i 1) n)])
        (define v2 (vector-ref nums j))
        (when (<= (abs (- v1 v2)) target)
          (define c2 (vector-ref dp j))
          (vector-set! dp j (max (+ c1 1) c2))))))

  (vector-ref dp (- n 1)))

(module+ test
  (require rackunit
           json)
  (test-case "example 1"
    (define nums (string->jsexpr "[1,3,6,4,1,2]"))
    (define target 2)
    (define output 3)
    (check-equal? (maximum-jumps nums target) output))
  (test-case "example 2"
    (define nums (string->jsexpr "[1,3,6,4,1,2]"))
    (define target 3)
    (define output 5)
    (check-equal? (maximum-jumps nums target) output))
  (test-case "example 3"
    (define nums (string->jsexpr "[1,3,6,4,1,2]"))
    (define target 0)
    (define output -1)
    (check-equal? (maximum-jumps nums target) output)))
