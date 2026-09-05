#lang racket

(define (decode-ciphertext encodedText rows)
    (define n (string-length encodedText))
    (define h rows)
    (define w (quotient n h))

    (define out (open-output-string))

    (for ([y (in-range w)])
        (let loop ([i 0] [j y])
            (define index (+ (* i w) j))
            (when (< index n)
                (display (string-ref encodedText index) out)
                (loop (+ i 1) (+ j 1))
            )
        )
    )

    (string-trim (get-output-string out) #:left? #f)
)

(module+ main
    (define encoded-text "iveo    eed   l te   olc")
    (define rows 4)
    (decode-ciphertext encoded-text rows)
)

(module+ test
    (require rackunit)
    (test-case "example1" 
        (define encoded-text "ch   ie   pr")
        (define rows 3)
        (define output "cipher")
        (check-equal? (decode-ciphertext encoded-text rows) output)     
    )
    (test-case "example2" 
        (define encoded-text "iveo    eed   l te   olc")
        (define rows 4)
        (define output "i love leetcode")
        (check-equal? (decode-ciphertext encoded-text rows) output)     
    )
    (test-case "example2" 
        (define encoded-text "coding")
        (define rows 1)
        (define output "coding")
        (check-equal? (decode-ciphertext encoded-text rows) output)     
    )
)