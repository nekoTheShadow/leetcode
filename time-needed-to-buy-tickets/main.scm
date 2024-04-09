(define (time-required-to-buy tickets k)
    (define T (list->vector tickets))
    (define ret 0)
    (let loop ((i 0))
        (if (= i (vector-length T))
            (loop 0)
            (begin
                (if (> (vector-ref T i) 0)
                    (begin
                        (vector-set! T i (- (vector-ref T i) 1))
                        (set! ret (+ ret 1))
                    )
                    'pass
                )
                (if (= (vector-ref T k) 0)
                    ret
                    (loop (+ i 1))
                )
            )
        )

    )
)
