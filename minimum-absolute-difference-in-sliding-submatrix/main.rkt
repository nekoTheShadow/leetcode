#lang racket

(define (min-abs-diff grid k)
  (define matrix (list->vector (map list->vector grid)))
  (define h (vector-length matrix))
  (define w (vector-length (vector-ref matrix 0)))

  (for/list ([x (in-range (+ (- h k) 1))])
    (for/list ([y (in-range (+ (- w k) 1))])
      (define st
        (for*/set ([dx (in-range k)]
                   [dy (in-range k)])
          (vector-ref (vector-ref matrix (+ x dx)) (+ y dy))))
      (define vec
        (vector-sort (for/vector ([item (in-set st)])
                       item)
                     <))

      (if (= (vector-length vec) 1)
          0
          (for/fold ([acc 1000000]) ([i (in-range (- (vector-length vec) 1))])
            (min acc (abs (- (vector-ref vec i) (vector-ref vec (+ i 1))))))))))

(provide min-abs-diff)
