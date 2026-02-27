#lang racket

(require "./main.rkt"
         rackunit)

(define (testing vals output)
  (check-equal? (sum-root-to-leaf (create-tree vals)) output))

(module+ test
  (testing '(1 0 1 0 1 0 1) 22)
  (testing '(0) 0))
