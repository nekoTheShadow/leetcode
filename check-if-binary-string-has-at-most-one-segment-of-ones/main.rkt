#lang racket

(define (check-ones-segment s)
  (<= (length (regexp-match* #rx"(0+|1+)" s)) 2))

(provide check-ones-segment)
