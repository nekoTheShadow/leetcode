#lang racket

(define (binary-gap n)
  (let loop ([x n]
             [cur 0]
             [pre 1000]
             [ret 0])
    (if (= x 0)
        ret
        (if (or (= (modulo x 2) 0))
            (loop (quotient x 2) (+ cur 1) pre ret)
            (loop (quotient x 2) (+ cur 1) cur (max ret (- cur pre)))))))

(provide binary-gap)
