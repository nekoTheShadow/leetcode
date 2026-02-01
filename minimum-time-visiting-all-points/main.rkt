#lang racket

(define (min-time-to-visit-all-points points)
  (let loop ([total 0]
             [lst1 points]
             [lst2 (cdr points)])
    (if (null? lst2)
        total
        (loop (+ total (get-distance (car lst1) (car lst2))) (cdr lst1) (cdr lst2)))))

(define (get-distance p1 p2)
  (max (abs (- (first p1) (first p2))) (abs (- (second p1) (second p2)))))

(provide min-time-to-visit-all-points)
