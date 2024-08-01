(define (count-seniors details)
    (if (null? details)
        0
        (if (> (string->number (substring (car details) 11 13)) 60)
            (+ 1 (count-seniors (cdr details)))
            (count-seniors (cdr details))
        )
    )
)
