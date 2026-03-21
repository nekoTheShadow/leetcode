#lang racket

(define (reverse-submatrix grid x y k)
  (define mat
    (for/vector ([row grid])
      (list->vector row)))

  (for ([i (in-range (quotient k 2))])
    (for ([j (in-range k)])
      (define p1 (+ x i))
      (define p2 (+ x (- k i 1)))
      (define q (+ y j))

      (define v1 (vector-ref (vector-ref mat p1) q))
      (define v2 (vector-ref (vector-ref mat p2) q))

      (vector-set! (vector-ref mat p2) q v1)
      (vector-set! (vector-ref mat p1) q v2)))

  (for/list ([row mat])
    (vector->list row)))

(provide reverse-submatrix)
