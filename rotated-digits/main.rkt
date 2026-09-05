#lang racket

(define (rotated-digits n)
  (for/fold ([count 0]) ([x (in-range 1 (+ n 1))])
    (let ([y (rotate x)])
      (if (and (not (= y -1)) (not (= x y)))
          (+ count 1)
          count))))

(define (rotate num)
  (define (rotate-sub x)
    (cond
      [(= x 0) 0]
      [(= x 1) 1]
      [(= x 8) 8]
      [(= x 2) 5]
      [(= x 5) 2]
      [(= x 6) 9]
      [(= x 9) 6]
      [else -1]))

  (let loop ([n num]
             [ys '()])
    (if (= n 0)
        (for/fold ([acc 0]) ([y ys])
          (+ (* acc 10) y))
        (let ([y (rotate-sub (modulo n 10))])
          (if (= y -1)
              -1
              (loop (quotient n 10) (cons y ys)))))))

(module+ test
  (require rackunit)
  (check-equal? (rotated-digits 10) 4)
  (check-equal? (rotated-digits 1) 0)
  (check-equal? (rotated-digits 2) 1))
