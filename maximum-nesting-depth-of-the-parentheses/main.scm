(define(max-depth s)
    (let loop ((i 0) (c 0) (ret 0))
        (cond
            ((= i (string-length s)) ret)
            ((char=? #\( (string-ref s i)) (loop (+ i 1) (+ c 1) ret))
            ((char=? #\) (string-ref s i)) (loop (+ i 1) (- c 1) (max ret c)))
            (else (loop (+ i 1) c ret))
        )
    )
)