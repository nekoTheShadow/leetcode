#lang racket

(define (angle-clock hour minutes)
  (define hour-angle (+ (* 30 (modulo hour 12)) (* 0.5 minutes)))
  (define minutes-angle (* 6 minutes))
  (define angle (abs (- hour-angle minutes-angle)))
  (min angle (- 360 angle)))

(module+ test
  (require rackunit)
  (check-equal? (angle-clock 12 30) 165.0)
  (check-equal? (angle-clock 3 30) 75.0)
  (check-equal? (angle-clock 3 15) 7.5))
