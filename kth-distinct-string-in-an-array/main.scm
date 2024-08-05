(define (kth-distinct arr k)
    (define h (make-hash))
    (for-each
        (lambda (x) (hash-set! h x (+ 1 (hash-ref h x 0))))
        arr
    )

    (let loop ((a arr) (n 1))
        (if (null? a)
            ""
            (let ((x (car a)))
                (if (= 1 (hash-ref h x))
                    (if (= n k)
                        x
                        (loop (cdr a) (+ n 1))
                    )
                    (loop (cdr a) n)
                )
            )
        )
    )
)
