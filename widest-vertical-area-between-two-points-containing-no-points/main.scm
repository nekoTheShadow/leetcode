(define(max-width-of-vertical-area points)
    (let loop ((A (sort (map car points) <))
               (N (length points))
               (ret 0))
        (if (= N 1)
            ret
            (loop (cdr A) (- N 1) (max ret (- (cadr A) (car A))))))
)
