#lang racket

(define (total-waviness num1 num2)
  (for/sum ([x (in-range num1 (+ num2 1))]) (count-waviness x)))

(define (integer->digits x)
  (if (< x 10)
      (list x)
      (cons (modulo x 10) (integer->digits (quotient x 10)))))

(define (count-waviness x)
  (let/ec return
    (when (< x 100)
      (return 0))
    (define digits (integer->digits x))
    (for/sum ([d1 digits] [d2 (cdr digits)] [d3 (cddr digits)])
             (if (or [and (< d1 d2) (> d2 d3)] [and (> d1 d2) (< d2 d3)]) 1 0))))

(module+ test
  (require rackunit)
  (check-equal? (total-waviness 120 130) 3)
  (check-equal? (total-waviness 198 202) 3)
  (check-equal? (total-waviness 4848 4848) 2)
  (check-equal? (total-waviness 2 18) 0))
