(define (min-difference nums)
    (define n (length nums))
    (define sorted-nums (list->vector (sort nums <)))

    (if (< n 5)
        0
        (min (- (vector-ref sorted-nums (- n 1)) (vector-ref sorted-nums 3))
             (- (vector-ref sorted-nums (- n 2)) (vector-ref sorted-nums 2))
             (- (vector-ref sorted-nums (- n 3)) (vector-ref sorted-nums 1))
             (- (vector-ref sorted-nums (- n 4)) (vector-ref sorted-nums 0)))))
