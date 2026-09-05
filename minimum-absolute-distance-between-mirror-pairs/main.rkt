#lang racket

(define (min-mirror-pair-distance nums)
  (define ht (make-hash))
  (define ret 1000000)

  (for ([(num i) (in-indexed nums)])
    (when (hash-has-key? ht num)
      (define j (hash-ref ht num))
      (set! ret (min ret (- i j))))
    (hash-set! ht (rev num) i))

  (if (= ret 1000000) -1 ret))

(define (rev x)
  (let loop ([tot 0]
             [n x])
    (if (= n 0)
        tot
        (loop (+ (* tot 10) (modulo n 10)) (quotient n 10)))))

(module+ test
  (require rackunit
           json)
  (test-case "Example 1"
    (define nums (string->jsexpr "[12,21,45,33,54]"))
    (define output 1)
    (check-equal? (min-mirror-pair-distance nums) output))
  (test-case "Example 2"
    (define nums (string->jsexpr "[120,21]"))
    (define output 1)
    (check-equal? (min-mirror-pair-distance nums) output))
  (test-case "Example 3"
    (define nums (string->jsexpr "[21,120]"))
    (define output -1)
    (check-equal? (min-mirror-pair-distance nums) output)))
