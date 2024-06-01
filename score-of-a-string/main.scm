(define (score-of-string s)
    (let loop ((i 0) (sum 0))
        (if (= i (- (string-length s) 1)) 
            sum
            (loop (+ i 1) (+ sum (abs (- (char->integer (string-ref s i)) (char->integer (string-ref s (+ i 1)))))))
        )
    )
)
