#lang racket

; # @param {Integer} n
; # @return {Integer}
; def max_product(n) = n.digits.max(2).reduce(:*)

(define/contract (max-product n)
  (-> exact-integer? exact-integer?)
  (define digits (sort (number->digits n) >))
  (define max1 (list-ref digits 0))
  (define max2 (list-ref digits 1))
  (* max1 max2))

(define (number->digits n)
  (if (= n 0)
      '()
      (cons (modulo n 10) (number->digits (quotient n 10)))))

(module+ test
  (require rackunit)
  (check-equal? (max-product 31) 3)
  (check-equal? (max-product 22) 4)
  (check-equal? (max-product 124) 8))
