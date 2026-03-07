#lang racket

(require "./main.rkt"
         rackunit)

(check-equal? (check-ones-segment "1001") #f)
(check-equal? (check-ones-segment "110") #t)
