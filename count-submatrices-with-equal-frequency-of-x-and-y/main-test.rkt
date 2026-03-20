#lang racket

(require "main.rkt"
         rackunit)

(check-equal? (number-of-submatrices (list (list #\X #\Y #\.) (list #\Y #\. #\.))) 3)

(check-equal? (number-of-submatrices (list (list #\X #\X) (list #\X #\Y))) 0)

(check-equal? (number-of-submatrices (list (list #\. #\.) (list #\. #\.))) 0)
