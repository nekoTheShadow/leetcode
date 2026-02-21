#lang racket

(define (count-prime-set-bits left right)
  (let loop ([n left]
             [count 0])
    (if (<= n right)
        (if (prime? (bit-count n))
            (loop (+ n 1) (+ count 1))
            (loop (+ n 1) count))
        count)))

(define (bit-count n)
  (let loop ([x n]
             [count 0])
    (if (= x 0)
        count
        (loop (quotient x 2) (+ count (modulo x 2))))))

(define (prime? n)
  (if (< n 2)
      #f
      (let loop ([x 2])
        (if (<= (* x x) n)
            (if (= (modulo n x) 0)
                #f
                (loop (+ x 1)))
            #t))))

(provide count-prime-set-bits)
