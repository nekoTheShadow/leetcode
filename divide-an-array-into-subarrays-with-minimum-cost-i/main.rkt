#lang racket

(define (minimum-cost nums)
  (let loop ([vals (cdr nums)]
             [min1 100]
             [min2 100])
    (if (null? vals)
        (+ (car nums) min1 min2)
        (cond
          [(<= (car vals) min1) (loop (cdr vals) (car vals) min1)]
          [(<= (car vals) min2) (loop (cdr vals) min1 (car vals))]
          [else (loop (cdr vals) min1 min2)]))))

(provide minimum-cost)
