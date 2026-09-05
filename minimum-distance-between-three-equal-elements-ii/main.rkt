#lang racket

(define (minimum-distance nums)
  (define ht (make-hash))
  (define ans 1000000000)

  (for ([(num i) (in-indexed nums)])
    (hash-update! ht num (lambda (lst) (cons i lst)) '())
    (define vals (hash-ref ht num))
    (define i1 (lst-ref vals 0))
    (define i3 (lst-ref vals 2))
    (when (and i1 i3)
      (set! ans (min ans (* 2 (- i1 i3))))))
  (if (= ans 1000000000) -1 ans))

(define (lst-ref lst i)
  (if (null? lst)
      #f
      (if (= i 0)
          (car lst)
          (lst-ref (cdr lst) (- i 1)))))

(module+ main
  (minimum-distance '(5 3 5 5 5)))

(module+ test
  (require rackunit)
  (check-eq? (minimum-distance '(1 2 1 1 3)) 6)
  (check-eq? (minimum-distance '(1 1 2 3 2 1 2)) 8)
  (check-eq? (minimum-distance '(1)) -1))
