(define (is-isomorphic s t)
    (define n (string-length s))
    (define ht1 (make-hash))
    (define ht2 (make-hash))


    (let loop ((i 0))
        (if (= i n)
            #t
            (let ((c1 (string-ref s i)) (c2 (string-ref t i)))
                (cond
                    ((not (equal? (hash-ref ht1 c1 c2) c2)) #f)
                    ((not (equal? (hash-ref ht2 c2 c1) c1)) #f)
                    (else (hash-set! ht1 c1 c2) (hash-set! ht2 c2 c1) (loop (+ i 1)))
                )
            )
        )
    )
)
