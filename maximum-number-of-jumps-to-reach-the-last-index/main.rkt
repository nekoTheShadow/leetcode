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
