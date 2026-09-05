#lang racket

(define (is-good nums)
  (define ht (make-hash))
  (define n -1)
  (for ([num nums])
    (hash-update! ht num add1 0)
    (set! n (add1 n)))

  (let/ec return
    (for ([i (in-range 1 n)])
      (unless (= (hash-ref ht i 0) 1)
        (return #f)))
    (= (hash-ref ht n 0) 2)))


(module+ test
  (require json
           rackunit)
  (check-equal? (is-good (string->jsexpr "[2, 1, 3]")) #f)
  (check-equal? (is-good (string->jsexpr "[1, 3, 3, 2]")) #t)
  (check-equal? (is-good (string->jsexpr "[1, 1]")) #t)
  (check-equal? (is-good (string->jsexpr "[3, 4, 4, 1, 2, 1]")) #f))
