#lang racket

(define (largest-submatrix matrix)
  (define m
    (for/vector ([row matrix])
      (list->vector row)))
  (define h (vector-length m))
  (define w (vector-length (vector-ref m 0)))
  (define ans 0)

  (for ([i (in-range h)])
    (for ([j (in-range w)])
      (when (and (= (m-ref m i j) 1) (> i 0))
        (m-set! m i j (+ (m-ref m i j) (m-ref m (- i 1) j)))))

    (for ([(v j) (in-indexed (vector-sort (vector-ref m i) >))])
      (set! ans (max ans (* v (+ j 1))))))

  ans)

(define (m-ref m x y)
  (vector-ref (vector-ref m x) y))

(define (m-set! m x y v)
  (vector-set! (vector-ref m x) y v))

(module+ test
  (require json
           rackunit)
  (require (submod ".."))

  (check-equal? (largest-submatrix (string->jsexpr "[[0,0,1],[1,1,1],[1,0,1]]")) 4)
  (check-equal? (largest-submatrix (string->jsexpr "[[1,0,1,0,1]]")) 3)
  (check-equal? (largest-submatrix (string->jsexpr "[[1,1,0],[1,0,1]]")) 2))
