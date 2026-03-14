#lang racket

(define (bitwise-complement n)
  (if (= n 0)
      1
      (bitwise-xor n (- (expt 2 (integer-length n)) 1))))

(provide bitwise-complement)
