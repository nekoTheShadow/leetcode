#lang racket

(define (max-distance colors)
  (define vec (list->vector colors))
  (define n (vector-length vec))
  (define mx 0)
  (for ([i (in-range n)])
    (for ([j (in-range (+ i 1) n)])
      (unless (= (vector-ref vec i) (vector-ref vec j))
        (set! mx (max mx (- j i))))))
  mx)

(module+ test
  (require rackunit
           json)
  (check-equal? (max-distance (string->jsexpr "[1,1,1,6,1,1,1]")) 3)
  (check-equal? (max-distance (string->jsexpr "[1,8,3,8,3]")) 4))
