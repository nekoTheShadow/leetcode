#lang racket

(define (gcd-of-odd-even-sums n)
  (gcd (total 1 n) (total 2 n)))

; 初項a、項数n、公差2の等差数列の和
(define (total a n)
  ; 末項 = 初項 + 公差 * (項数 - 1)
  (define b (+ a (* 2 (- n 1))))

  ; 和 = 項数 * (初項 + 末項) / 2
  (quotient (* n (+ a b)) 2))

(module+ test
  (require rackunit)
  (check-eq? (gcd-of-odd-even-sums 4) 4)
  (check-eq? (gcd-of-odd-even-sums 5) 5))
