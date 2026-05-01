#lang racket

(define (max-rotate-function nums)
  (solve (list->vector nums)))

(define (solve nums)
  (define n (vector-length nums))
  (define f0 (for/sum ([(num i) (in-indexed nums)]) (* num i)))
  (define tot (for/sum ([num nums]) num))
  (define ht (make-hash))
  (define (f k)
    (let/ec return
      (when (= k 0)
        (return f0))
      (unless (hash-has-key? ht k)
        (hash-set! ht k (- (+ (f (- k 1)) tot) (* n (vector-ref nums (- n k))))))
      (return (hash-ref ht k))))

  (for/fold ([acc f0]) ([k (in-range n)])
    (max acc (f k))))

(module+ test
  (require rackunit
           json)
  (test-case "Example 1"
    (define nums (string->jsexpr "[4,3,2,6]"))
    (define output 26)
    (check-equal? (max-rotate-function nums) output))
  (test-case "Example 2"
    (define nums (string->jsexpr "[100]"))
    (define output 0)
    (check-equal? (max-rotate-function nums) output)))
