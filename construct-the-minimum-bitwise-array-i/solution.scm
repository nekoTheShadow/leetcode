(define (min-bitwise-array nums)
    (map search nums)
)

(define (search n)
    (if (= n 2)
        -1
        (let loop ((v 0))
            (if (= (bitwise-ior v (+ v 1)) n)
                v
                (loop (+ v 1))
            )
        )
    )
)
