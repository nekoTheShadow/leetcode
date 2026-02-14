#lang racket

(provide longest-balanced)

(define (longest-balanced s)
  (let ([n (string-length s)])
    (let loop ([i 0]
               [mx 0])
      (if (< i n)
          (loop (+ i 1) (max mx (get-max s n i)))
          mx))))

(define (get-max s n i)
  (let ([vec (make-vector 26 0)])
    (let loop ([j i]
               [mx 0])
      (if (< j n)
          (begin
            (inc vec (ord (string-ref s j)))
            (if (check vec)
                (loop (+ j 1) (max mx (+ 1 (- j i))))
                (loop (+ j 1) mx)))
          mx))))

(define (ord ch)
  (- (char->integer ch) (char->integer #\a)))

(define (inc vec pos)
  (vector-set! vec pos (+ 1 (vector-ref vec pos))))

(define (check vec)
  (let loop ([i 0]
             [fst 0])
    (if (< i 26)
        (let ([x (vector-ref vec i)])
          (cond
            [(= x 0) (loop (+ i 1) fst)]
            [(= fst 0) (loop (+ i 1) x)]
            [(= x fst) (loop (+ i 1) fst)]
            [else #f]))
        #t)))